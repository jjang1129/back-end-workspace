



let idSubmit = false;
let pwdSubmit= false;



 // id가 id인 태그에 input 값이 입력될때마다 실행되는 함수 


id.addEventListener("input",function(e){
	//비어있으면 안되고 
	// 영어 , 숫자로만 10~14글자 -> 정규표현식 
		// 시작은 영어로 
		const regExp=/^[a-zA-z][a-zA-Z0-9]{9,13}$/;
	
	// 중복체크 
	$.ajax({
		type:'post',
		url:'/check',
		data : {
			id:e.target.value
		},
		success: function(data){
			if(data){
				//정보가 있을 때니까 중복된 아이디입니다 
				idCheck.innerHTML="중복된 아이디입니다. 다시 입력해주세요 ㅠㅠ";
				idCheck.style.color="red";
				idSubmit =false;
			}else {
				//정보가 없을 때니까 사용가능한 아이디입니다
				if(regExp.test(e.target.value)){ 
					idCheck.innerHTML="OK!"
					idCheck.style.color="green";
					idSubmit =true;
				}else if(e.target.value === ""){
					
					idCheck.innerHTML ="";
					idSubmit =false;
				}
				else{
					idCheck.innerHTML="첫글자는 영어로, 영어 또는 숫자로만 10~14글자 입력";
					idCheck.style.color="red";
					idSubmit =false;
					
				}
			}
		}
	});
	
	
	
	


	
	console.log("아이디 입력");
});

// form태그에 onsubmit="return validate()"을 설정해놓음 
// 제출전에 이 함수가 실행됨

// return true/ false  : 전송 결정 여부를 설정할 수 있음 


password.addEventListener("input",function(e){
	// 특수문자 무조건 하나 이상 포함
	// 대문자,소문자 하나씩 전부다 포함이 되어 있는 경우 
	// 숫자도 하나씩 포함되어 있는 경우 
	const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$/;
	if(regExp.test(e.target.value)){
		pwdCheck.innerHTML = "OK!"
		pwdCheck.style.color="green";
		pwdSubmit = true;
	}else if(e.target.value ===""){
		pwdCheck.innerHTML = "";
		pwdSubmit = false;
	}
	 else	{
		pwdCheck.innerHTML ="특수문자,대문자,소문자,숫자 한개 이상 포함되어야합니다"
		pwdCheck.style.color ="red";
		pwdSubmit = false;
	}
	
});


function validate(){
	
	if(!idSubmit) id.focus();
	else if(!pwdSubmit) password.focus();
	return idSubmit && pwdSubmit;
}









