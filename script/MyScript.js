/**
 * 
 */
//console.log("script start");

//jQuery UI Datepicker.JQuery UIのカレンダー機能.
$.datepicker.setDefaults({
	//RFC3339形式の日付を指定
	//dateFormat : 'yy年mm月dd日',
	dateFormat : 'yy-mm-dd',
	changeYear : true,
	changeMonth: true,
	showOn     : "both",						//テキストボックスの横にボタンを追加
	buttonImage: 'jsp/img/calendar-icon.png',	//テキストボックス横のボタンの画像
	buttonText : "カレンダーから選択",				//ツールチップ表示文言
    buttonImageOnly: true						//単に画像として表示するか、ボタンとして表示しボタン内に画像を表示させるか
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

//console.log("script end");
