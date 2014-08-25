package chanjarster.weixin.bean;

import org.testng.Assert;
import org.testng.annotations.Test;

import chanjarster.weixin.api.WxConsts;
import chanjarster.weixin.bean.WxCustomMessage.WxArticle;

@Test
public class WxCustomMessageTest {

  public void testTextReply() {
    WxCustomMessage reply = new WxCustomMessage();
    reply.setTouser("OPENID");
    reply.setMsgtype(WxConsts.CUSTOM_MSG_TEXT);
    reply.setContent("sfsfdsdf");
    Assert.assertEquals(reply.toJson(), "{\"touser\":\"OPENID\",\"msgtype\":\"text\",\"text\":{\"content\":\"sfsfdsdf\"}}");
  }
  
  public void testImageReply() {
    WxCustomMessage reply = new WxCustomMessage();
    reply.setTouser("OPENID");
    reply.setMsgtype(WxConsts.CUSTOM_MSG_IMAGE);
    reply.setMedia_id("MEDIA_ID");
    Assert.assertEquals(reply.toJson(), "{\"touser\":\"OPENID\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"MEDIA_ID\"}}");
  }
  
  public void testVoiceReply() {
    WxCustomMessage reply = new WxCustomMessage();
    reply.setTouser("OPENID");
    reply.setMsgtype(WxConsts.CUSTOM_MSG_VOICE);
    reply.setMedia_id("MEDIA_ID");
    Assert.assertEquals(reply.toJson(), "{\"touser\":\"OPENID\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"MEDIA_ID\"}}");
  }
  
  public void testVideoReply() {
    WxCustomMessage reply = new WxCustomMessage();
    reply.setTouser("OPENID");
    reply.setMsgtype(WxConsts.CUSTOM_MSG_VIDEO);
    reply.setMedia_id("MEDIA_ID");
    reply.setThumb_media_id("MEDIA_ID");
    reply.setTitle("TITLE");
    reply.setDescription("DESCRIPTION");
    Assert.assertEquals(reply.toJson(), "{\"touser\":\"OPENID\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"MEDIA_ID\",\"thumb_media_id\":\"MEDIA_ID\",\"title\":\"TITLE\",\"description\":\"DESCRIPTION\"}}");
  }
  
  public void testMusicReply() {
    WxCustomMessage reply = new WxCustomMessage();
    reply.setTouser("OPENID");
    reply.setMsgtype(WxConsts.CUSTOM_MSG_MUSIC);
    reply.setThumb_media_id("MEDIA_ID");
    reply.setDescription("DESCRIPTION");
    reply.setTitle("TITLE");
    reply.setMusicurl("MUSIC_URL");
    reply.setHqmusicurl("HQ_MUSIC_URL");
    Assert.assertEquals(reply.toJson(), "{\"touser\":\"OPENID\",\"msgtype\":\"music\",\"music\":{\"title\":\"TITLE\",\"description\":\"DESCRIPTION\",\"thumb_media_id\":\"MEDIA_ID\",\"musicurl\":\"MUSIC_URL\",\"hqmusicurl\":\"HQ_MUSIC_URL\"}}");
  }
  
  public void testNewsReply() {
    WxCustomMessage reply = new WxCustomMessage();
    reply.setTouser("OPENID");
    reply.setMsgtype(WxConsts.CUSTOM_MSG_NEWS);
    
    WxArticle article1 = new WxArticle();
    article1.setUrl("URL");
    article1.setPicurl("PIC_URL");
    article1.setDescription("Is Really A Happy Day");
    article1.setTitle("Happy Day");
    reply.getArticles().add(article1);
    
    WxArticle article2 = new WxArticle();
    article2.setUrl("URL");
    article2.setPicurl("PIC_URL");
    article2.setDescription("Is Really A Happy Day");
    article2.setTitle("Happy Day");
    reply.getArticles().add(article2);

    
    Assert.assertEquals(reply.toJson(), "{\"touser\":\"OPENID\",\"msgtype\":\"news\",\"articles\":[{\"title\":\"Happy Day\",\"description\":\"Is Really A Happy Day\",\"url\":\"URL\",\"picurl\":\"PIC_URL\"},{\"title\":\"Happy Day\",\"description\":\"Is Really A Happy Day\",\"url\":\"URL\",\"picurl\":\"PIC_URL\"}]}");
  }
  
}