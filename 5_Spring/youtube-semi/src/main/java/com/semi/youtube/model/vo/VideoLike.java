package com.semi.youtube.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class VideoLike {
	
       private int likeCode;
       private String id; // member
       private int videoCode; // video
       
}
