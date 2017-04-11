//tag:数字文本标记 1数字，0
function sumMoney(id,tag){
    $('#modal-content').modal({
        closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
        position: [0,],
        overlayId: 'modal-overlay',
        containerId: 'modal-content',
        onShow: function (dialog) {
            var modal = this;
            // if the user clicks "yes"
            $('.simplemodal-sure', dialog.data[0]).click(function () {
                var text=$("textarea").attr("value");

                $("input#"+id).attr("value",text);
                modal.close(); // or $.modal.close();
            });
        }
    });
}
function subWorkData(name){
}

