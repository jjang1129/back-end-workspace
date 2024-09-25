package com.kh.upload.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {
    private String endOfGameResult; // 게임 종료 결과
    private long gameCreation; // 게임 생성 시간
    private long gameDuration; // 게임 지속 시간
    private long gameEndTimestamp; // 게임 종료 타임스탬프
    private long gameId; // 게임 ID
    private String gameMode; // 게임 모드
    private String gameName; // 게임 이름
    private long gameStartTimestamp; // 게임 시작 타임스탬프
    private String gameType; // 게임 타입
    private String gameVersion; // 게임 버전
    private int mapId; // 맵 ID
    private List<ParticipantDto> participants; // 참가자 목록
    private String platformId; // 플랫폼 ID
    private int queueId; // 큐 ID
    private List<TeamDto> teams; // 팀 목록
    private String tournamentCode; // 토너먼트 코드
}
