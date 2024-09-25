package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {
    private int allInPings; // 모든 핑
    private int assistMePings; // 도움 요청 핑
    private int assists; // 어시스트 수
    private int baronKills; // 바론 처치 수
    private int bountyLevel; // 현상금 레벨
    private int champExperience; // 챔피언 경험치
    private int champLevel; // 챔피언 레벨
    private int championId; // 챔피언 ID
    private String championName; // 챔피언 이름
    private int commandPings; // 명령 핑
    private int championTransform; // 챔피언 변환
    private int consumablesPurchased; // 구매한 소모품 수
    private ChallengesDto challenges; // 도전 과제
    private int damageDealtToBuildings; // 건물에 대한 피해량
    private int damageDealtToObjectives; // 목표에 대한 피해량
    private int damageDealtToTurrets; // 포탑에 대한 피해량
    private int damageSelfMitigated; // 자신이 완화한 피해량
    private int deaths; // 사망 수
    private int detectorWardsPlaced; // 배치한 감지 와드 수
    private int doubleKills; // 더블킬 수
    private int dragonKills; // 드래곤 처치 수
    private boolean eligibleForProgression; // 진급 자격 여부
    private int enemyMissingPings; // 적 결석 핑
    private int enemyVisionPings; // 적 비전 핑
    private boolean firstBloodAssist; // 첫 처치 어시스트 여부
    private boolean firstBloodKill; // 첫 처치 여부
    private boolean firstTowerAssist; // 첫 포탑 어시스트 여부
    private boolean firstTowerKill; // 첫 포탑 처치 여부
    private boolean gameEndedInEarlySurrender; // 조기 항복 여부
    private boolean gameEndedInSurrender; // 항복으로 종료 여부
    private int holdPings; // 방어 핑
    private int getBackPings; // 귀환 핑
    private int goldEarned; // 획득한 골드
    private int goldSpent; // 사용한 골드
    private String individualPosition; // 개인 포지션
    private int inhibitorKills; // 억제기 처치 수
    private int inhibitorTakedowns; // 억제기 타격 수
    private int inhibitorsLost; // 잃은 억제기 수
    private int item0; // 아이템 0
    private int item1; // 아이템 1
    private int item2; // 아이템 2
    private int item3; // 아이템 3
    private int item4; // 아이템 4
    private int item5; // 아이템 5
    private int item6; // 아이템 6
    private int itemsPurchased; // 구매한 아이템 수
    private int killingSprees; // 연속 처치 수
    private int kills; // 처치 수
    private String lane; // 라인
    private int largestCriticalStrike; // 최대 크리티컬 스트라이크
    private int largestKillingSpree; // 최대 연속 처치
    private int largestMultiKill; // 최대 멀티킬
    private int longestTimeSpentLiving; // 생존 시간
    private int magicDamageDealt; // 마법 피해량
    private int magicDamageDealtToChampions; // 챔피언에게 준 마법 피해량
    private int magicDamageTaken; // 받은 마법 피해량
    private MissionsDto missions; // 미션
    private int neutralMinionsKilled; // 중립 미니언 처치 수
    private int needVisionPings; // 시야 필요 핑
    private int nexusKills; // 넥서스 처치 수
    private int nexusTakedowns; // 넥서스 타격 수
    private int nexusLost; // 잃은 넥서스 수
    private int objectivesStolen; // 훔친 목표 수
    private int objectivesStolenAssists; // 훔친 목표에 대한 어시스트 수
    private int onMyWayPings; // 가는 중 핑
    private int participantId; // 참가자 ID
    private int playerScore0; // 플레이어 점수 0
    private int playerScore1; // 플레이어 점수 1
    private int playerScore2; // 플레이어 점수 2
    private int playerScore3; // 플레이어 점수 3
    private int playerScore4; // 플레이어 점수 4
    private int playerScore5; // 플레이어 점수 5
    private int playerScore6; // 플레이어 점수 6
    private int playerScore7; // 플레이어 점수 7
    private int playerScore8; // 플레이어 점수 8
    private int playerScore9; // 플레이어 점수 9
    private int playerScore10; // 플레이어 점수 10
    private int playerScore11; // 플레이어 점수 11
    private int pentaKills; // 펜타킬 수
//    private PerksDto perks; // 특성
    private int physicalDamageDealt; // 물리 피해량
    private int physicalDamageDealtToChampions; // 챔피언에게 준 물리 피해량
    private int physicalDamageTaken; // 받은 물리 피해량
    private int placement; // 순위
    private int playerAugment1; // 플레이어 증강 1
    private int playerAugment2; // 플레이어 증강 2
    private int playerAugment3; // 플레이어 증강 3
    private int playerAugment4; // 플레이어 증강 4
    private int playerSubteamId; // 플레이어 서브팀 ID
    private int pushPings; // 푸시 핑
    private int profileIcon; // 프로필 아이콘
    private String puuid; // PUUID
    private int quadraKills; // 쿼드라킬 수
    private String riotIdGameName; // 라이엇 ID 게임 이름
    private String riotIdName; // 라이엇 ID 이름
    private String riotIdTagline; // 라이엇 ID 태그라인
    private String role; // 역할
    private int sightWardsBoughtInGame; // 게임에서 구매한 시야 와드 수
    private int spell1Casts; // 스펠 1 사용 횟수
    private int spell2Casts; // 스펠 2 사용 횟수
    private int spell3Casts; // 스펠 3 사용 횟수
    private int spell4Casts; // 스펠 4 사용 횟수
    private int summoner1Casts; // 소환사 스펠 1 사용 횟수
    private int summoner1Id; // 소환사 스펠 1 ID
    private int summoner2Casts; // 소환사 스펠 2 사용 횟수
    private int summoner2Id; // 소환사 스펠 2 ID
    private String summonerId; // 소환사 ID
    private int summonerLevel; // 소환사 레벨
    private String summonerName; // 소환사 이름
    private boolean teamEarlySurrendered; // 팀이 조기 항복했는지 여부
    private int teamId; // 팀 ID
    private String teamPosition; // 팀 포지션
    private int timeCCingOthers; // 다른 플레이어에게 CC 시간을 준 총 시간
    private int timePlayed; // 총 플레이 시간
    private int totalDamageDealt; // 총 피해량
    private int totalDamageDealtToChampions; // 챔피언에게 준 총 피해량
    private int totalDamageTaken; // 받은 총 피해량
    private int totalHeal; // 총 치유량
    private int totalMinionsKilled; // 처치한 미니언 수
    private int totalTimeCCDealt; // CC를 준 총 시간
    private int totalUnitsHealed; // 치유된 유닛 수
    private int towerKills; // 포탑 처치 수
    private int towerTakedowns; // 포탑 타격 수
    private int towersLost; // 잃은 포탑 수
    private int trueDamageDealt; // 고정 피해량
    private int trueDamageDealtToChampions; // 챔피언에게 준 고정 피해량
    private int trueDamageTaken; // 받은 고정 피해량
    private int turretPlatesTaken; // 포탑 플레이트 처치 수
    private int turretsTakenWithRiftHerald; // 리프트 헤럴드로 처치한 포탑 수
    private int twentyMinionsIn3SecondsCount; // 3초 내에 20 미니언 처치 수
    private int twoWardsOneSweeperCount; // 2 와드 1 스위퍼 수
    private int unseenRecalls; // 보이지 않는 리콜 수
    private float visionScorePerMinute; // 분당 비전 점수
    private int wardsGuarded; // 방어한 와드 수
    private int wardTakedowns; // 처치한 와드 수
    private int wardTakedownsBefore20M; // 20분 전에 처치한 와드 수
}

	
	

