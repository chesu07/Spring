function writeCheck(){
	if(document.writeForm.writer.value == ""){
		alert("작성자를 입력해주세요");
		document.write.focus();
		return;
	}
	if(document.writeForm.pass.value == ""){
		alert("비밀번호를 입력해주세요");
		document.pass.focus();
		return;
	}
	if(document.writeForm.email.value == ""){
		alert("이메일을 입력해주세요");
		document.email.focus();
		return;
	}
	if(document.writeForm.subject.value == ""){
		alert("제목을 입력해주세요");
		document.subject.focus();
		return;
	}
	if(document.writeForm.content.value == ""){
		alert("내용을 입력해주세요");
		document.content.focus();
		return;
	}
	document.writeForm.submit();
}

function addFile(num){
	var v = document.getElementById('list_dis');
	if(num == "b"){
		v.style.display = "";
	}
	if(num == "a"){
		v.style.display = "none";
	}
}