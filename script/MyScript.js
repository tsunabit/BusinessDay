/**
 * 
 */
//JQuery UI
$(function() {
	//jQuery UI Datepicker.JQuery UIのカレンダー機能.
	$.datepicker.setDefaults({
		//dateFormat : 'yy年mm月dd日',
		dateFormat : 'yy-mm-dd',					//RFC3339形式の日付を指定
		changeYear : true,
		changeMonth: true,
		showOn     : "both",						//テキストボックスの横にボタンを追加
		buttonImage: 'jsp/img/calendar-icon.png',	//テキストボックス横のボタンの画像
		buttonText : "カレンダーから選択",				//ツールチップ表示文言
		buttonImageOnly: true						//単に画像として表示するか、ボタンとして表示しボタン内に画像を表示させるか
	});

	//jspの[id=startDate]にJQuery UIのdatepickerを設定
	$('#startDate').datepicker({
		onSelect: function (selectedDate) {
			var option = 'minDate';
			//datepickerのminDateオプションを設定
            $('#endDate').datepicker('option', option, selectedDate);
		}
	});

	//jspの[id=endDate]にJQuery UIのdatepickerを設定
	$('#endDate').datepicker({
		onSelect: function (selectedDate) {
			var option = 'maxDate';
			//datepickerのmaxDateオプションを設定
            $('#startDate').datepicker('option', option, selectedDate);
		}
	});
});

//validation
$(function() {
	$('input[name=startDate').bind('blur' , function() {
		if($(this).val() == ''){
			$('form #startDate').html('input error');
			$('form #startDate').css('color' , '#f00');
		}
	})
	$('input[name=endDate').bind('blur' , function() {
		if($(this).val() == ''){
			$('form #endDate').html('input error');
			$('form #endDate').css('color' , '#f00');
		}
	})
});

