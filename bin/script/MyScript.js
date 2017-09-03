/**
 * 
 */
$.datepicker.setDefaults({
	dateFormat : 'yy年mm月dd日',
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

