/**
 * 
 */

//JQuery UI
$(function() {
	//jQuery UI Datepicker.JQuery UIのカレンダー機能.
	$.datepicker.setDefaults({
		//dateFormat : 'yy年mm月dd日',
		dateFormat : 'yy-mm-dd',					//RFC3339形式の日付を指定
		changeYear : true,							//年の変更が可能
		changeMonth: true,							//月の変更が可能
		showOn     : "both",						//テキストボックス、カレンダーアイコンどちらをクリックしてもカレンダー表示
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
	}).on('change', function() {
		//inputの値が書き換えられた時
		//ここのセレクタはJQueryで自動に付加されるもの(hasDatepicker)がある。jspには記載していない。
		if($('input#startDate.hasDatepicker').val() == ''){
			$(this).addClass('error').parent().append('<p class="error">※この項目は必ず入力してください</p>');
		}
	}).bind('blur' , function() {
		//他にフォーカスが移動した時
		if(selectedDate == ''){
			//errorクラスを追加
			//$(this).addClass('error');
			//$('form > #startDateError').html('Start day input error').css('color' , '#f00');
			$(this).addClass('error').parent().append('<p class="error">※この項目は必ず入力してください</p>');
		}
	}).bind('focus' , function() {
		//フォーカスが当たった時
		if($('input#startDate.hasDatepicker').next() !== false){
			//要素内全ての「兄弟」要素からclass="error"を削除
			$(this).removeClass('error').siblings().remove('.error');
		}
	});
	
	
	
	//jspの[id=endDate]にJQuery UIのdatepickerを設定
	$('#endDate').datepicker({
		onSelect: function (selectedDate) {
			var option = 'maxDate';
			//datepickerのmaxDateオプションを設定
            $('#startDate').datepicker('option', option, selectedDate);
		}
	}).on('change', function() {
		//inputの値が書き換えられた時
		//ここのセレクタはJQueryで自動に付加されるもの(hasDatepicker)がある。jspには記載していない。
		if($('input#endDate.hasDatepicker').val() == ''){
			$(this).addClass('error').parent().append('<p class="error">※この項目は必ず入力してください</p>');
		}
	}).bind('blur' , function() {
		//他にフォーカスが移動した時
		if(selectedDate == ''){
			//errorクラスを追加
			//$(this).addClass('error');
			//$('form > #endDateError').html('end day input error').css('color' , '#f00');
			$(this).addClass('error').parent().append('<p class="error">※この項目は必ず入力してください</p>');
		}
	}).bind('focus' , function() {
		//フォーカスが当たった時
		if($('input#endDate.hasDatepicker').next() !== false){
			//要素内全ての「兄弟」要素からclass="error"を削除
			$(this).removeClass('error').siblings().remove('.error');
		}
	});
	
	function display(msg) {
		$("<p>").html(msg).appendTo(document.body);
	}
	
});


/*
$(function() {
	$('input[name=startDate]').bind('blur' , function() {
		if($(this).val() == ''){
			//errorクラスを追加
			//$(this).addClass('error');
			//$('form > #startDateError').html('Start day input error').css('color' , '#f00');
			$(this).addClass('error').parent().append('<p class="error">※この項目は必ず入力してください</p>');
		}
	})
	.bind('focus' , function() {
		if($(this).next() !== false){
			//要素内全ての「兄弟」要素からclass="error"を削除
			$(this).removeClass('error').siblings().remove('.error');
		}
	});
	
	$('input[name=endDate]').bind('blur' , function() {
		if($(this).val() == ''){
			//errorクラスを追加
			//$(this).addClass('error');
			//$('form > #endDateError').html('End day input error').css('color' , '#f00');
			$(this).addClass('error').parent().append('<p class="error">※この項目は必ず入力してください</p>');
		}
	})
	.bind('focus' , function() {
		if($(this).next() !== false){
			//要素内全ての「兄弟」要素からclass="error"を削除
			$(this).removeClass('error').siblings().remove('.error');
		}
	});
});
*/


//$(function() {
//	$('.ui-datepicker-trigger').bind(click , function(){
//		$('#startDate').eq(0).focus();
//	});
//	
//});

