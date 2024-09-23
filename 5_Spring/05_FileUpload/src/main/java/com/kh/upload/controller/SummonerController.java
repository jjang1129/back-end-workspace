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
import com.kh.upload.model.vo.Paging;

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
        	
//            String puu = response.getContent();
//           String url2 =  "/lol/summoner/v4/summoners/by-puuid/"+ puu ;
//           ArrayList<Paging> code = restTemplate.getForObject(url2, ArrayList.class);
           //https://asia.api.riotgames.com/lol/match/v5/matches/KR_7293407940?api_key=RGAPI-3be5323b-6b61-4aed-96c8-887c28dff082
        	InfoDto dto = restTemplate.getForObject("https://asia.api.riotgames.com/lol/match/v5/matches/"+ matchCode.get(0) + "?api_key=" + API_KEY, InfoDto.class);
//        	InfoDto dto2 = restTemplate.getForObject("https://asia.api.riotgames.com/lol/match/v5/matches/KR_7277245614?api_key=RGAPI-d41ece30-605a-4b72-b671-861bb5343f75" , InfoDto.class);
        	System.out.println(matchCode.get(0));
        	System.out.println("DTO2 : " + dto);
            model.addAttribute("summoner", response);
            model.addAttribute("codeList", matchCode); 
            System.out.println(dto.getTeams());
            model.addAttribute("test", dto.getEndOfGameResult()); 
        } catch (Exception e) {
            model.addAttribute("error", "소환사를 찾을 수 없습니다.");
        }
        
        return "summoner"; // JSP 파일 이름
    }
}
