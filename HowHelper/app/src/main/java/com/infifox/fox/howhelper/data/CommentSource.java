package com.infifox.fox.howhelper.data;

import com.infifox.fox.howhelper.base.BaseSource;
import com.infifox.fox.howhelper.bean.Comment;

import rx.Observable;

/**
 * Created by jili on 2/24/17.
 */

public interface CommentSource extends BaseSource {
    Observable<Comment> loadBeforeComment (int storyID, int lastCommentId);
    Observable<Comment> loadLongComment (int storyID, int lastCommentId);
    Observable<Comment> loadShortComment (int storyID, int lastCommentId);

}
