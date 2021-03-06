<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/common/header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="${ctx}/js/bootstraptable/extensions/export/bootstrap-table-export.min.js" type="text/javascript"></script>
<script src="${ctx}/js/tableExport/tableExport.min.js" type="text/javascript"></script>
<script src="${ctx}/js/x-editable/js/bootstrap-editable.min.js" type="text/javascript"></script>
<link href="${ctx}/js/x-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div class="container">
    <div id="toolbar">
        <button id="remove" class="btn btn-danger" disabled>
            <i class="glyphicon glyphicon-remove"></i> Delete
        </button>
    </div>
    <table id="table"
           data-toolbar="#toolbar"
           data-search="true"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="true"
           data-show-export="true"
           data-detail-view="true"
           data-detail-formatter="detailFormatter"
           data-minimum-count-columns="2"
           data-show-pagination-switch="true"
           data-pagination="true"
           data-id-field="id"
           data-page-list="[10, 25, 50, 100, ALL]"
           data-show-footer="false"
           data-side-pagination="server"
           data-url="${ctx }/userController/getUserList"
           data-response-handler="responseHandler">
    </table>
</div>



</body>
<script type="text/javascript">
$.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);
var $table = $('#table'),
$remove = $('#remove'),
selections = [];

$(function(){
	
	initTable();
	
});



function initTable() {
$table.bootstrapTable({
    height: $(window).height(),
    columns: [
        [
            {
                field: 'state',
                checkbox: true,
                rowspan: 2,
                align: 'center',
                valign: 'middle'
            }, {
                title: 'Item ID',
                field: 'id',
                rowspan: 2,
                align: 'center',
                valign: 'middle',
                sortable: true,
                footerFormatter: totalTextFormatter
            }, {
                title: 'Item Detail',
                colspan: 3,
                align: 'center'
            }
        ],
        [
            {
                field: 'name',
                title: 'Item Name',
                sortable: true,
                editable: true,
                footerFormatter: totalNameFormatter,
                align: 'center'
            }, {
                field: 'price',
                title: 'Item Price',
                sortable: true,
                align: 'center',
                editable: {
                    type: 'text',
                    title: 'Item Price',
                    validate: function (value) {
                        value = $.trim(value);
                        if (!value) {
                            return 'This field is required';
                        }
                        if (!/^$/.test(value)) {
                            return 'This field needs to start width $.'
                        }
                        var data = $table.bootstrapTable('getData'),
                            index = $(this).parents('tr').data('index');
                        console.log(data[index]);
                        return '';
                    }
                },
                footerFormatter: totalPriceFormatter
            }, {
                field: 'operate',
                title: 'Item Operate',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }
        ]
    ]
});
// sometimes footer render error.
setTimeout(function () {
    $table.bootstrapTable('resetView');
}, 200);
$table.on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
    $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);

    // save your data, here just save the current page
    selections = getIdSelections();
    // push or splice the selections if you want to save all data selections
});
$table.on('expand-row.bs.table', function (e, index, row, $detail) {
    if (index % 2 == 1) {
        $detail.html('Loading from ajax request...');
        $.get('LICENSE', function (res) {
            $detail.html(res.replace(/\n/g, '<br>'));
        });
    }
});
$table.on('all.bs.table', function (e, name, args) {
    console.log(name, args);
});
$remove.click(function () {
    var ids = getIdSelections();
    $table.bootstrapTable('remove', {
        field: 'id',
        values: ids
    });
    $remove.prop('disabled', true);
});
$(window).resize(function () {
    $table.bootstrapTable('resetView', {
        height: $(window).height()
    });
});
}


function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}

function responseHandler(res) {
    $.each(res.rows, function (i, row) {
        row.state = $.inArray(row.id, selections) !== -1;
    });
    return res;
}

function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

function operateFormatter(value, row, index) {
    return [
        '<a class="like" href="javascript:void(0)" title="Like">',
        '<i class="glyphicon glyphicon-heart"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}

window.operateEvents = {
    'click .like': function (e, value, row, index) {
        alert('You click like action, row: ' + JSON.stringify(row));
    },
    'click .remove': function (e, value, row, index) {
        $table.bootstrapTable('remove', {
            field: 'id',
            values: [row.id]
        });
    }
};

function totalTextFormatter(data) {
    return 'Total';
}

function totalNameFormatter(data) {
    return data.length;
}

function totalPriceFormatter(data) {
    var total = 0;
    $.each(data, function (i, row) {
        total += +(row.price.substring(1));
    });
    return '$' + total;
}
</script>
</html>