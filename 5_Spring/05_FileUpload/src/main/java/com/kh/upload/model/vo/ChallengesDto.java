package com.kh.upload.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.AllArgsConstructor;
@Data // 모든 필드에 대한 getter, setter 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
public class ChallengesDto {
    private int twelveAssistStreakCount; // 12어시스트 연속 카운트
    private int baronBuffGoldAdvantageOverThreshold; // 바론 버프 골드 우위
    private float controlWardTimeCoverageInRiverOrEnemyHalf; // 시야 와드 커버 시간
    private int earliestBaron; // 가장 빠른 바론 처치 시간
    private int earliestDragonTakedown; // 가장 빠른 드래곤 처치 시간
    private int earliestElderDragon; // 가장 빠른 엘더 드래곤 처치 시간
    private int earlyLaningPhaseGoldExpAdvantage; // 초기 라인 단계 골드 경험치 우위
    private int fasterSupportQuestCompletion; // 빠른 서포트 퀘스트 완료
    private int fastestLegendary; // 가장 빠른 전설 아이템 완료
    private int hadAfkTeammate; // AFK 팀원이 있었는지 여부
    private int highestChampionDamage; // 가장 높은 챔피언 피해량
    private int highestCrowdControlScore; // 가장 높은 군중 제어 점수
    private int highestWardKills; // 가장 많은 와드 처치 수
    private int junglerKillsEarlyJungle; // 정글러의 초기 정글 처치 수
    private int killsOnLanersEarlyJungleAsJungler; // 정글러가 라인 플레이어를 처치한 수
    private int laningPhaseGoldExpAdvantage; // 라인 단계 골드 경험치 우위
    private int legendaryCount; // 전설 아이템 개수
    private float maxCsAdvantageOnLaneOpponent; // 상대방 라인 상대 최대 CS 우위
    private int maxLevelLeadLaneOpponent; // 상대방 라인 상대 최대 레벨 우위
    private int mostWardsDestroyedOneSweeper; // 한 번의 스위퍼로 가장 많이 파괴한 와드 수
    private int mythicItemUsed; // 사용한 전설 아이템 ID
    private int playedChampSelectPosition; // 챔피언 선택에서의 포지션
    private int soloTurretsLategame; // 솔로로 파괴한 타워 수
    private int takedownsFirst25Minutes; // 첫 25분 동안의 처치 수
    private int teleportTakedowns; // 텔레포트로 처치한 수
    private int thirdInhibitorDestroyedTime; // 세 번째 억제기 파괴 시간
    private int threeWardsOneSweeperCount; // 한 번의 스위퍼로 파괴한 와드 수
    private float visionScoreAdvantageLaneOpponent; // 상대방에 대한 시야 점수 우위
    private int infernalScalePickup; // 인펄날 스케일 픽업 수
    private int fistBumpParticipation; // fist bump 참여 수
    private int voidMonsterKill; // 공허 몬스터 처치 수
    private int abilityUses; // 사용한 능력 수
    private int acesBefore15Minutes; // 15분 이전에 획득한 에이스 수
    private float alliedJungleMonsterKills; // 아군 정글 몬스터 처치 수
    private int baronTakedowns; // 바론 처치 수
    private int blastConeOppositeOpponentCount; // 적 정글 쪽 블라스트 콘을 사용한 횟수
    private int bountyGold; // 보상 골드
    private int buffsStolen; // 스틸한 버프 수
    private int completeSupportQuestInTime; // 제 시간에 완료한 서포트 퀘스트 수
    private int controlWardsPlaced; // 배치한 컨트롤 와드 수
    private float damagePerMinute; // 분당 피해량
    private float damageTakenOnTeamPercentage; // 팀 전체에서 받은 피해량 비율
    private int dancedWithRiftHerald; // 리프트 헤럴드와 함께한 횟수
    private int deathsByEnemyChamps; // 적 챔피언에게 사망한 횟수
    private int dodgeSkillShotsSmallWindow; // 짧은 시간 내에 회피한 스킬 샷 수
    private int doubleAces; // 더블 에이스 수
    private int dragonTakedowns; // 드래곤 처치 수
    private List<Integer> legendaryItemUsed; // 사용한 전설 아이템 ID 리스트
    private float effectiveHealAndShielding; // 효과적인 치유 및 방어량
    private int elderDragonKillsWithOpposingSoul; // 상대 영혼과 함께 처치한 엘더 드래곤 수
    private int elderDragonMultikills; // 엘더 드래곤 멀티킬 수
    private int enemyChampionImmobilizations; // 적 챔피언 기절 수
    private float enemyJungleMonsterKills; // 적 정글 몬스터 처치 수
    private int epicMonsterKillsNearEnemyJungler; // 적 정글러 근처의 에픽 몬스터 처치 수
    private int epicMonsterKillsWithin30SecondsOfSpawn; // 생성 후 30초 이내 처치한 에픽 몬스터 수
    private int epicMonsterSteals; // 스틸한 에픽 몬스터 수
    private int epicMonsterStolenWithoutSmite; // 스마이트 없이 스틸한 에픽 몬스터 수
    private int firstTurretKilled; // 첫 번째 타워 처치 여부
    private float firstTurretKilledTime; // 첫 번째 타워 처치 시간
    private int flawlessAces; // 결점 없는 에이스 수
    private int fullTeamTakedown; // 전체 팀 처치 수
    private float gameLength; // 게임 길이
    private int getTakedownsInAllLanesEarlyJungleAsLaner; // 정글러로서 모든 라인에서 처치한 수
    private float goldPerMinute; // 분당 골드 수
    private int hadOpenNexus; // 넥서스가 열려 있었는지 여부
    private int immobilizeAndKillWithAlly; // 아군과 함께 기절 및 처치 수
    private int initialBuffCount; // 초기 버프 수
    private int initialCrabCount; // 초기 크랩 수
    private float jungleCsBefore10Minutes; // 10분 전 정글 CS 수
    private int junglerTakedownsNearDamagedEpicMonster; // 피해를 입은 에픽 몬스터 근처에서 처치한 정글러 수
    private float kda; // 킬-죽음-어시스트 비율
    private int killAfterHiddenWithAlly; // 아군과 함께 숨은 후 처치한 수
    private int killedChampTookFullTeamDamageSurvived; // 피해를 입고 살아남은 적 챔피언 처치 수
    private int killingSprees; // 킬 스프리 수
    private float killParticipation; // 킬 참여율
    private int killsNearEnemyTurret; // 적 타워 근처에서 처치한 수
    private int killsOnOtherLanesEarlyJungleAsLaner; // 라인 플레이어로서 정글에서 처치한 수
    private int killsOnRecentlyHealedByAramPack; // 최근 회복한 아람팩에서 처치한 수
    private int killsUnderOwnTurret; // 자기 타워 아래에서 처치한 수
    private int killsWithHelpFromEpicMonster; // 에픽 몬스터의 도움으로 처치한 수
    private int knockEnemyIntoTeamAndKill; // 적을 팀으로 끌어내린 후 처치한 수
    private int kTurretsDestroyedBeforePlatesFall; // 플레이트가 떨어지기 전에 파괴한 타워 수
    private int landSkillShotsEarlyGame; // 초반에 맞춘 스킬샷 수
    private int laneMinionsFirst10Minutes; // 첫 10분 동안의 미니언 처치 수
    private int lostAnInhibitor; // 억제기 손실 여부
    private int maxKillDeficit; // 최대 킬 부족 수
    private int mejaisFullStackInTime; // 제시간에 메자이 풀 스택 수
    private float moreEnemyJungleThanOpponent; // 적 정글보다 더 많은 CS 여부
    private int multiKillOneSpell; // 한 스펠로 멀티킬 수
    private int multikills; // 멀티킬 수
    private int multikillsAfterAggressiveFlash; // 공격적인 플래시 후 멀티킬 수
    private int multiTurretRiftHeraldCount; // 다수 타워에서의 리프트 헤럴드 수
    private int outerTurretExecutesBefore10Minutes; // 10분 이전에 외부 타워에서 처치한 수
    private int outnumberedKills; // 수적으로 우위를 점하고 처치한 수
    private int outnumberedNexusKill; // 수적으로 우위에서 넥서스를 처치한 수
    private int perfectDragonSoulsTaken; // 완벽한 드래곤 영혼 수
    private int perfectGame; // 완벽한 게임 여부
    private int pickKillWithAlly; // 아군과 함께 처치한 수
    private int poroExplosions; // 포로 폭발 수
    private int quickCleanse; // 빠른 클렌징 수
    private int quickFirstTurret; // 빠른 첫 타워 처치 수
    private int quickSoloKills; // 빠른 솔로 킬 수
    private int riftHeraldTakedowns; // 리프트 헤럴드 처치 수
    private int saveAllyFromDeath; // 아군을 살린 수
    private int scuttleCrabKills; // 스커틀 크랩 처치 수
    private float shortestTimeToAceFromFirstTakedown; // 첫 처치 이후 가장 빠른 에이스 시간
    private int skillshotsDodged; // 회피한 스킬샷 수
    private int skillshotsHit; // 적중한 스킬샷 수
    private int snowballsHit; // 적중한 눈덩이 수
    private int soloBaronKills; // 솔로 바론 처치 수
    private int swarM_DefeatAatrox; // SWARM: 아트록스 처치 여부
    private int swarm_DefeatBriar; // SWARM: 브라이어 처치 여부
    private int swarm_DefeatMiniBosses; // SWARM: 미니 보스 처치 여부
    private int swarm_EvolveWeapon; // SWARM: 무기 진화 여부
    private int swarm_Have3Passives; // SWARM: 3개의 패시브 보유 여부
    private int swarm_KillEnemy; // SWARM: 적 처치 수
    private int swarm_PickupGold; // SWARM: 골드 수집 수
    private int swarm_ReachLevel50; // SWARM: 레벨 50 도달 여부
    private int swarm_Survive15Min; // SWARM: 15분 생존 여부
    private int swarm_WinWith5EvolvedWeapons; // SWARM: 5개의 진화된 무기로 승리 여부
    private int soloKills; // 솔로 킬 수
    private int stealthWardsPlaced; // 배치한 스텔스 와드 수
    private int survivedSingleDigitHpCount; // 1% 이하 생존 횟수
    private int survivedThreeImmobilizesInFight; // 전투 중 3회 이상 기절에서 생존 여부
    private int takedownOnFirstTurret; // 첫 타워에서의 처치 수
    private int takedowns; // 총 처치 수
    private int takedownsAfterGainingLevelAdvantage; // 레벨 우위를 점한 후 처치 수
    private int takedownsBeforeJungleMinionSpawn; // 정글 미니언 생성 전 처치 수
    private int takedownsFirstXMinutes; // 처음 X분 동안의 처치 수
    private int takedownsInAlcove; // 알코브에서의 처치 수
    private int takedownsInEnemyFountain; // 적 넥서스 근처에서의 처치 수
    private int teamBaronKills; // 팀 바론 처치 수
    private float teamDamagePercentage; // 팀 피해량 비율
    private int teamElderDragonKills; // 팀 엘더 드래곤 처치 수
    private int teamRiftHeraldKills; // 팀 리프트 헤럴드 처치 수
    private int tookLargeDamageSurvived; // 큰 피해를 받고 생존 여부
    private int turretPlatesTaken; // 파괴한 타워 플레이트 수
    private int turretsTakenWithRiftHerald; // 리프트 헤럴드와 함께 파괴한 타워 수
    private int turretTakedowns; // 파괴한 타워 수
    private int twentyMinionsIn3SecondsCount; // 3초 이내 20개 미니언 처치 수
    private int twoWardsOneSweeperCount; // 1개의 스위퍼로 2개의 와드를 처치한 수
    private int unseenRecalls; // 눈에 보이지 않는 리콜 수
    private float visionScorePerMinute; // 분당 시야 점수
    private int wardsGuarded; // 보호한 와드 수
    private int wardTakedowns; // 처치한 와드 수
    private int wardTakedownsBefore20M; // 20분 이전에 처치한 와드 수
}
