//package com.poscoict.cookie;
//
//import javax.servlet.http.Cookie;
//
//public class Cookie {
//	
//	boolean result=true; // 로직 수행을 위해 필요한 변수
//	Cookie[] cookies = request.getCookies(); // 조회수 중복 증가 방지를 위해 쿠키를 사용한다.
//    Cookie viewCookie = null; // 비교하기 위해 새로운 쿠키 생성
//    
//    if (cookies != null && cookies.length > 0){
//        for (int i = 0; i < cookies.length; i++){          	
//            // Cookie의 이름이 존재하는지 확인 후 존재하면 viewCookie에 값을 넣어준다. 
//            if (cookies[i].getName().equals("cookie" + no)){ 
//                viewCookie = cookies[i];
//            }
//        }
//    }
//    
//    // 만일 viewCookie가 null일 경우 쿠키를 생성해서 조회수 증가 로직을 처리함.
//    if (viewCookie == null) {                        
//        Cookie newCookie = new Cookie("cookie" + no ,String.valueOf(no)); // 쿠키 생성(이름, 값) 
//        response.addCookie(newCookie); // 쿠키 추가  
//        result =  boardRepository.update(no); // 조회수 증가
//    }
//    
//	// 조회가 끝나면 쿠키를 삭제해준다.
//	Cookie[] cookies = request.getCookies();	
//	if(cookies!=null) {
//		System.out.println(cookies.length);
//		for (int i = 0; i < cookies.length; i++){          	
//			cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
//			response.addCookie(cookies[i]); // 응답 헤더에 추가
//        }
//	}
//	
//
//}
