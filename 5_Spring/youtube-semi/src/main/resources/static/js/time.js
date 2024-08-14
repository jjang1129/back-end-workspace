

const videoMeta = document.querySelectorAll(".video-meta");
// p 태그들 

videoMeta.forEach(meta => {
  let date =meta.getAttribute("data-video-date");
  // p태그들의 data video date  => video date 
  date = new Date(date);
  // date 타입으로 변환 
  
  const videoDate = meta.querySelector(".video-date");
  //span 태그들 
  videoDate.innerHTML=getTime(date);
  
  // html로 p태그의 변환한 데이터들을 span에 입력 
 
 if(videoDate.innerHTML.substring("0","1") / 7 <= 1){
	
	videoDate.innerHTML= videoDate.innerHTML.substring("0","1") / 7 + "주일전"
 }
});



function getTime(date){
	const now = new Date();
	const diff = Math.floor((now-date)/1000);
	
	
	const rtf = new Intl.RelativeTimeFormat('ko',{numeric:'auto'});
	
	if(diff < 60){
		return rtf.format(-diff,'seconds');
	} else if (diff < 3600){
		return rtf.format(-Math.floor(diff/60),'minutes');
	}else if (diff < 86400){
		return rtf.format(-Math.floor(diff/3600),'hours');		
	} else if ( diff >= 604800){
		return rtf.format(-Math.floor(diff/86400),'days');
	} 
	
}

