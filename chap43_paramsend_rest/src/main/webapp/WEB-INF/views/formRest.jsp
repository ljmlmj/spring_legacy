<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form Rest - @PathVarialbe 사용 예제</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			//[전송1 버튼 click 이벤트 핸들러]
			$("#btn1").on('click', function(e){
				if($("#grade").val()=== ''){
					alert('학년을 입력하세요.');
					$("#grade").focus();
					return false;
				}
				//[1] 폼의 데이터 전송방법
				// 하나씩 개별적으로 전달하는 방법
				var name = $('#name').val();
				var grade = $("#grade").val();
				
				// action3.do -> action4.do 단계적으로 주석을 풀어
				$.ajax({
					url : '${contextPath}/action3.do/name1/' + name + "/grade1/" + grade,
					type : 'get',
					dataType : 'text',
					//[1]방법
					data : {name : name, grade : grade},
					success : function(data){				//success callback (data)는 JSON 타입이다.
						//[1] 문자열로 반환받는 경우 action3.do
						console.log("data : " + data);
						$('#resultDiv').html(data);
						
						//[2] JSON Type으로 반환받는 경우 action4.do
						var javascriptObj = JSON.parse(data);
						// Json 문자열 -> 자바스크립트 객체로 변환
						console.log(javascriptObj);		//자바스크립트 객체 출력
						
						//html 생성
						var table = "<table border='1'><tr><td>이름</td><td>학년</td></tr>";
							table += '<tr>';
							table += '<td>' + javascriptObj.name + '</td>';
							table += '<td>' + javascriptObj.grade + '</td>';
							table += '</tr>';
							table += "</table>";
							
						$('#resultDiv').html(table);
					},	//success
					error : function(xhr, status){
						console.log(xhr+" : " + status);	//에러 코드
					}
				});	//$.ajax
				
			});	//버튼 click 이벤트 핸들러 끝
			
			//[전송2 버튼 click 이벤트 핸들러]
			$("#btn2").on('click', function(e){
				if($("#grade").val()=== ''){
					alert('학년을 입력하세요.');
					$("#grade").focus();
					return false;
				}
				//[2] 폼의 데이터 전송방법
				// 하나씩 개별적으로 전달하는 방법
				var name = $('#name').val();
				var grade = $("#grade").val();
				
				// action3.do -> action4.do 단계적으로 주석을 풀어
				$.ajax({
					url : '${contextPath}/action3.do/name1/' + name + "/grade1/" + grade,
					type : 'get',
					dataType : 'text',
					//[1]방법
					data : {name : name, grade : grade},
					success : function(data){
						//[1] 문자열로 반환받는 경우 action3.do
						console.log("data : " + data);
						$('#resultDiv').html(data);
						
						//[2] JSON Type으로 반환받는 경우 action4.do
						var javascriptObj = JSON.parse(data);
						// Json 문자열 -> 자바스크립트 객체로 변환
						console.log(javascriptObj);		//자바스크립트 객체 출력
						
						//html 생성
						var table = "<table border='1'><tr><td>이름</td><td>학년</td></tr>";
							table += '<tr>';
							table += '<td>' + javascriptObj.name + '</td>';
							table += '<td>' + javascriptObj.grade + '</td>';
							table += '</tr>';
							table += "</table>";
							
						$('#resultDiv').html(table);
					},	//success
					error : function(xhr, status){
						console.log(xhr+" : " + status);	//에러 코드
					}
				});	//$.ajax
				
			});	//버튼 click 이벤트 핸들러 끝
			
		}); // end .ready
	</script>

</head>
<body>
	<form name="formm" id="formm" method="post" action="${pageContext.request.contextPath}/action3.do">
	
		이름 : <input type="text" name="name" id="name" value="${member.name}" /><br>
		학년 : <input type="text" name="grade" id="grade" /><br><br>
		<input type="button" id="btn1" value="전송1" /><br><br>
		<input type="button" id="btn2" value="전송2" /><br><br>
	</form>
	<div id="resultDiv"></div>
</body>
</html>