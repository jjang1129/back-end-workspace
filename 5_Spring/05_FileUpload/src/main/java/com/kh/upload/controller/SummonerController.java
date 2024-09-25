package com.kh.upload.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.kh.upload.model.vo.AccountDto;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.InfoDto;
import com.kh.upload.model.vo.MatchDto;
import com.kh.upload.model.vo.MatchResultDto;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.model.vo.MatchResultDto;

@Controller
public class SummonerController {

    private final String API_KEY = "RGAPI-d41ece30-605a-4b72-b671-861bb5343f75"; // 여기에 실제 API 키를 입력하세요.

    @GetMapping("/summoner")
    public String getSummoner(@RequestParam String gameName,@RequestParam String tagLine ,Model model) {
        RestTemplate restTemplate = new RestTemplate();
      
        String url = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameName +"/" + tagLine + "?api_key=" + API_KEY;

        try {
        	AccountDto response = restTemplate.getForObject(url, AccountDto.class);
        	System.out.println(response);
        	String puuid = response.getPuuid();
        	List<String> matchCode = (List<String>) restTemplate.getForObject("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=20&api_key=" + API_KEY, List.class); 
        	System.out.println("나옴? " + matchCode);
        	

          List<MatchDto> matchList = new ArrayList<MatchDto>();
        	for(int i=0; i<matchCode.size(); i++) {
        		matchList.add(restTemplate.getForObject("https://asia.api.riotgames.com/lol/match/v5/matches/"+ matchCode.get(i) + "?api_key=" + API_KEY, MatchDto.class));
        	}
        
        	MatchDto matchDto = restTemplate.getForObject("https://asia.api.riotgames.com/lol/match/v5/matches/"+ matchCode.get(0) + "?api_key=" + API_KEY, MatchDto.class);
        	
        	System.out.println("첫번째 경기 matchDto" + matchDto);
        	model.addAttribute("firstGame", matchDto);
        	
        	int[] myteam = new int[matchList.size()];
  for(int i=0; i<matchList.size(); i ++) {
	  for(int j=0; j<matchList.get(i).getInfo().getParticipants().size(); j++) {
		 
	  if(matchList.get(i).getInfo().getParticipants().get(j).getRiotIdGameName().trim().toLowerCase().equals(gameName)) {
		  
		 int k = (matchList.get(i).getInfo().getParticipants().get(j).getTeamId());
		 myteam[i] = k;
		  break;
	  }
	  
  }
  }   

 
          
            
	List<MatchResultDto> resultList = new ArrayList<MatchResultDto>();
	
			for (int i = 0; i < myteam.length; i++) {
				for (int j = 0; j < 2; j++) {
				
					if (myteam[i] == matchList.get(i).getInfo().getTeams().get(j).getTeamId()) {
						System.out.println(myteam[i] +"/" +  matchList.get(i).getInfo().getTeams().get(j).isWin());
						resultList.add(new MatchResultDto()
								.builder()
								.riotIdGameName(gameName)
								.teamId(myteam[i])
								.win(matchList.get(i).getInfo().getTeams().get(j).isWin())
								.build());
						
					}
				}
				
			}
 
			model.addAttribute("result", resultList);
			System.out.println(resultList.size());
			System.out.println(resultList);
			for(int i=0; i<resultList.size(); i++) {
				System.out.println(resultList.get(i));
			}
			

        	// 매치코드가 20개인데 // 1번 매치코드를 타고 들어가서 // paticipant를 가서 애네를 최대10번 돌아서 검색한 닉네임과 일치여부를 확인하고 그 시점의 team id ex )  100
        	
        	
        	
//        	InfoDto dto2 = restTemplate.getForObject("https://asia.api.riotgames.com/lol/match/v5/matches/KR_7277245614?api_key=RGAPI-d41ece30-605a-4b72-b671-861bb5343f75" , InfoDto.class);
        	
        
          
         List<String> wins = new ArrayList<String>();
         
        
          
            model.addAttribute("summoner", response);
            model.addAttribute("codeList", matchCode); 
            model.addAttribute("match",matchList);
            
            
          
            
   
        } catch (Exception e) {
            model.addAttribute("error", "소환사를 찾을 수 없습니다.");
        }
        
        return "summoner"; // JSP 파일 이름
    }
}
