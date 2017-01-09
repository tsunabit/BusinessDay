/**
 * 
 */

console.log("script start");

$.datepicker.setDefaults({
	//RFC3339形式の日付を指定
	//dateFormat : 'yy年mm月dd日',
	dateFormat : 'yy-mm-dd',
	changeYear : true,
	changeMonth: true,
	showOn     : "both",
	buttonImage: 'jsp/img/calendar-icon.png',
    buttonText : "カレンダーから選択",
    buttonImageOnly: true
});

$('#startDate').datepicker({
	onSelect: function(startDate) {
		$('#endDate').datepicker({
			minDate:startDate
		});
	    //alert(startDate);
	  }
});

$('#endDate').datepicker({
});

console.log("script end");
