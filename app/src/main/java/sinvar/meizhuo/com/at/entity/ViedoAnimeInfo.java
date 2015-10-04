package sinvar.meizhuo.com.at.entity;

import java.util.List;

/**
 * Created by sinvar on 2015/10/2.
 */
public class ViedoAnimeInfo {

    @Override
    public String toString() {
        return "ViedoAnimeInfo{" +
                "anime=" + anime +
                '}';
    }

    /**
     * anime : [{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1ew9qwfgqyyj30b50acdg5.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296"},"Author":"谭丽丽","Duration":"07:58","Id":"1624","Brief":"这部短片故事立意于现代人沉迷于社交网络，忽视身边的亲友。 我们可以在社交网络背后隐藏自己的表情，可以将每一句话发送之前反复修改，但是面对身边的家人和朋友，我们却很难袒露心声。故事讲述了一只企鹅，它乐于通过飘洋而来的漂流瓶中的故事去了解通过彼岸每一位的主人，她试图加入他们的世界，但是却没有任何人做出回应，悲观的主人公在放弃的同时却意外收到了一个特别的瓶子，它的主人看似来自遥远北极，而这位\u201c不速之客\u201d，给企鹅小姐带来一个巨大的惊喜。 背景音乐：《some》、《here is a heart》 感谢支持和帮助我的朋友们, 在今后的生活和工作上加油!不要忘了最初的梦想, 坚持！","DetailPic":"http://ww1.sinaimg.cn/large/0066P23Wjw1ew9qwji01pj30hs0buwfy.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTI2MTMxMDQ4OA==.html?from=s1.8-1-1.2","Name":"动画短片《等等等瓶》(478)"},{"HomePic":"http://ww4.sinaimg.cn/large/0066P23Wjw1ew6m6i23dkj3034034mxi.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTMxOTY0MzA4MA%3D%3D&keyframe=1&ev=1&ts=1442559325&type=mp4&ep=diaQGEyIX80C4CbYiT8bNC%2FhJiYPXJZ3kmLN%2FrYLAMZuOezC6DPcqJu3SP8%3D&token=6760&oip=2021932405&ctype=12&sid=444255932557112c33ba0","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTMxOTY0MzA4MA%3D%3D&keyframe=1&ev=1&ts=1442559325&type=mp4&ep=diaQGEyIX80C4CbYiT8bNC%2FhJiYPXJZ3kmLN%2FrYLAMZuOezC6DPcqJu3SP8%3D&token=6760&oip=2021932405&ctype=12&sid=444255932557112c33ba0","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTMxOTY0MzA4MA%3D%3D&keyframe=1&ev=1&ts=1442559325&type=mp4&ep=diaQGEyIX80C4CbYiT8bNC%2FhJiYPXJZ3kmLN%2FrYLAMZuOezC6DPcqJu3SP8%3D&token=6760&oip=2021932405&ctype=12&sid=444255932557112c33ba0"},"Author":"Vic CHHUN & Mohamed","Duration":"04:22","Id":"1623","Brief":"《MEGALIZER》是不是很精彩？其实在那之后还有更精彩的MEGALIZER II，这一次15位动画人集结在一起进行了一次更加疯狂的动画杂耍，一次更具创想的动画派对！而相比第一部，参与者也更加大胆地创造着有趣的造型和动作设计，相信这样一支集体创作的MV会让你小心脏再次到处乱跳！","DetailPic":"http://ww4.sinaimg.cn/large/0066P23Wjw1ew6m6mgspij30hs07smxw.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTMxOTY0MzA4MA==.html","Name":"MEGALIZER II(262)"},{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1ew4f9yrrykj30d20cjjrn.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTI4MDI1MzcxNg%3D%3D&keyframe=1&ev=1&ts=1442394915&type=hd2&ep=ciaQGEqEUscB4CPZjj8bNn3gc3QNXJZ3kmaB%2FKYbAcZuG6DBzjPcqJqzS%2Fs%3D&token=7354&oip=2021932405&ctype=12&sid=044239491506612aa2732","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTI4MDI1MzcxNg%3D%3D&keyframe=1&ev=1&ts=1442394915&type=hd2&ep=ciaQGEqEUscB4CPZjj8bNn3gc3QNXJZ3kmaB%2FKYbAcZuG6DBzjPcqJqzS%2Fs%3D&token=7354&oip=2021932405&ctype=12&sid=044239491506612aa2732","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTI4MDI1MzcxNg%3D%3D&keyframe=1&ev=1&ts=1442394915&type=hd2&ep=ciaQGEqEUscB4CPZjj8bNn3gc3QNXJZ3kmaB%2FKYbAcZuG6DBzjPcqJqzS%2Fs%3D&token=7354&oip=2021932405&ctype=12&sid=044239491506612aa2732"},"Author":"柴艺萌 王冠岚 瞿盼 吉月 林北琳 杨杨","Duration":"08:01","Id":"1621","Brief":"大连交通大学艺术学院优秀毕业设计 本片讲述坐轮椅的小男孩于现实与幻境找寻自我的故事","DetailPic":"http://ww1.sinaimg.cn/large/0066P23Wjw1ew4fa2srxnj30kp09twf0.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTI4MDI1MzcxNg==.html?from=s1.8-1-1.2","Name":"我不知道风在往哪个方向吹(481)"},{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1ew4poju4usj3034034jrk.jpg","Year":"2013","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XNTk1Nzg4MzEy&keyframe=1&ev=1&ts=1442416627&type=hd3&ep=eiaQGE2MUMgC4ibaij8bb3rgfHBeXJZ0kkSE%2F5g1BMZuPaHQkT7Zxw%3D%3D&token=8080&oip=2021932405&ctype=12&sid=8442416627552128f287a","sd":"http://pl.youku.com/playlist/m3u8?vid=XNTk1Nzg4MzEy&keyframe=1&ev=1&ts=1442416627&type=hd3&ep=eiaQGE2MUMgC4ibaij8bb3rgfHBeXJZ0kkSE%2F5g1BMZuPaHQkT7Zxw%3D%3D&token=8080&oip=2021932405&ctype=12&sid=8442416627552128f287a","hd":"http://pl.youku.com/playlist/m3u8?vid=XNTk1Nzg4MzEy&keyframe=1&ev=1&ts=1442416627&type=hd3&ep=eiaQGE2MUMgC4ibaij8bb3rgfHBeXJZ0kkSE%2F5g1BMZuPaHQkT7Zxw%3D%3D&token=8080&oip=2021932405&ctype=12&sid=8442416627552128f287a"},"Author":"吕乐","Duration":"17:08","Id":"1619","Brief":"这是一部难得的意境与深度都在很高水准的作品。作品不仅在动画和电影的区分上值得作为样本探讨，更是一小节让人心灵通畅的思辨体操。 本片根据鹿桥的小说集《人子》改编，为\u201c美好2013:大师微电影\u201d系列中的一部。","DetailPic":"http://ww3.sinaimg.cn/large/0066P23Wjw1ew4ponx9cmj30hs07sgmn.jpg","VideoUrl":"http://v.youku.com/v_show/id_XNTk1Nzg4MzEy.html?from=s1.8-1-1.1","Name":"一维(1028)"},{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1ew37hm634tj30fv0d574r.jpg","Year":"2014","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XNzM5MDY0MjIw&keyframe=1&ev=1&ts=1442304199&type=hd2&ep=ciaQGEqNUs8J7CfYiz8bMyq0IiYNXJZ0vGKA%2FKYLAMZ%2BMa%2FQkTjTxQ%3D%3D&token=8622&oip=2021932405&ctype=12&sid=044230419947312d6ffa2","sd":"http://pl.youku.com/playlist/m3u8?vid=XNzM5MDY0MjIw&keyframe=1&ev=1&ts=1442304199&type=hd2&ep=ciaQGEqNUs8J7CfYiz8bMyq0IiYNXJZ0vGKA%2FKYLAMZ%2BMa%2FQkTjTxQ%3D%3D&token=8622&oip=2021932405&ctype=12&sid=044230419947312d6ffa2","hd":"http://pl.youku.com/playlist/m3u8?vid=XNzM5MDY0MjIw&keyframe=1&ev=1&ts=1442304199&type=hd2&ep=ciaQGEqNUs8J7CfYiz8bMyq0IiYNXJZ0vGKA%2FKYLAMZ%2BMa%2FQkTjTxQ%3D%3D&token=8622&oip=2021932405&ctype=12&sid=044230419947312d6ffa2"},"Author":"留学生","Duration":"03:11","Id":"1618","Brief":"讲述了一个搞笑的故事 . 由法国动画学校,乔治梅立耶的四个动画学生历时8个月完成.","DetailPic":"http://ww3.sinaimg.cn/large/0066P23Wjw1ew37hq6p4kj30nb0at3yv.jpg","VideoUrl":"http://v.youku.com/v_show/id_XNzM5MDY0MjIw.html","Name":"Ben(191)"},{"HomePic":"http://ww1.sinaimg.cn/large/0066P23Wjw1ew6mm3ximfj30340343yp.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTMxOTY0MjY0MA%3D%3D&keyframe=1&ev=1&ts=1442559341&type=flv&ep=dyaQGEyIX80E5CPWgD8bNi7lISQJXJZ3kmLN%2FrYLAMZ%2BIejC6DPcqJqySf8%3D&token=7270&oip=2021932405&ctype=12&sid=544255934109812a27ec6","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTMxOTY0MjY0MA%3D%3D&keyframe=1&ev=1&ts=1442559341&type=flv&ep=dyaQGEyIX80E5CPWgD8bNi7lISQJXJZ3kmLN%2FrYLAMZ%2BIejC6DPcqJqySf8%3D&token=7270&oip=2021932405&ctype=12&sid=544255934109812a27ec6","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTMxOTY0MjY0MA%3D%3D&keyframe=1&ev=1&ts=1442559341&type=flv&ep=dyaQGEyIX80E5CPWgD8bNi7lISQJXJZ3kmLN%2FrYLAMZ%2BIejC6DPcqJqySf8%3D&token=7270&oip=2021932405&ctype=12&sid=544255934109812a27ec6"},"Author":"一群动画人","Duration":"02:17","Id":"1617","Brief":"当犹如起搏器一样的电子舞曲响起，小心脏会随之加快噗通跳动，整个人都会兴奋起来，而当这劲爆的舞曲遇到一群动画人又会怎样呢？12位法国动画人动画人（如果没看错的话）联手奉献了这部\u201cMEGALIZER\u201d，看得你都会跟着一起舞动！总之，观看时注意肢体语言不要过多，容易打翻身边的物品\u2026\u2026","DetailPic":"http://ww1.sinaimg.cn/large/0066P23Wjw1ew6mm85g15j30hs07sdh9.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTMxOTY0MjY0MA==.html","Name":"MEGALIZER(137)"},{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1evurkucpz8j3034034t8l.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTI3MTI1NzUxMg%3D%3D&keyframe=1&ev=1&ts=1441673992&type=hd2&ep=cCaQG0%2BKVccJ5yLbgT8bYn3rJXMLXJZ3kmaG%2FLYbAcVuLaDCzjPcqJSySfY%3D&token=9279&oip=2021932405&ctype=12&sid=2441673992149125a9a44","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTI3MTI1NzUxMg%3D%3D&keyframe=1&ev=1&ts=1441673992&type=hd2&ep=cCaQG0%2BKVccJ5yLbgT8bYn3rJXMLXJZ3kmaG%2FLYbAcVuLaDCzjPcqJSySfY%3D&token=9279&oip=2021932405&ctype=12&sid=2441673992149125a9a44","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTI3MTI1NzUxMg%3D%3D&keyframe=1&ev=1&ts=1441673992&type=hd2&ep=cCaQG0%2BKVccJ5yLbgT8bYn3rJXMLXJZ3kmaG%2FLYbAcVuLaDCzjPcqJSySfY%3D&token=9279&oip=2021932405&ctype=12&sid=2441673992149125a9a44"},"Author":"王柯","Duration":"04:02","Id":"1616","Brief":"一个动作超级给力的作品，肉对肉的冲撞将二维动画的运动魅力展现的淋漓尽致，喜欢昆汀美学和《罪恶之城》这种美漫风格的盆友，这部作品一定是你的菜哟！","DetailPic":"http://ww3.sinaimg.cn/large/0066P23Wjw1evurkyiqnej304g01yglg.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTI3MTI1NzUxMg==.html","Name":"大无畏(242)"},{"HomePic":"http://ww4.sinaimg.cn/large/0066P23Wjw1evus0gl5qcj3034034dg3.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTMwMjQxNjU2OA%3D%3D&keyframe=1&ev=1&ts=1441673973&type=flv&ep=cSaQG0%2BKVccH5iLajj8bNirkc3BdXJZ3kmLC%2FIgDSMV%2BLerA6DPcqJu5Svo%3D&token=6945&oip=2021932405&ctype=12&sid=344167397315612a6677b","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTMwMjQxNjU2OA%3D%3D&keyframe=1&ev=1&ts=1441673973&type=flv&ep=cSaQG0%2BKVccH5iLajj8bNirkc3BdXJZ3kmLC%2FIgDSMV%2BLerA6DPcqJu5Svo%3D&token=6945&oip=2021932405&ctype=12&sid=344167397315612a6677b","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTMwMjQxNjU2OA%3D%3D&keyframe=1&ev=1&ts=1441673973&type=flv&ep=cSaQG0%2BKVccH5iLajj8bNirkc3BdXJZ3kmLC%2FIgDSMV%2BLerA6DPcqJu5Svo%3D&token=6945&oip=2021932405&ctype=12&sid=344167397315612a6677b"},"Author":"samantha maurer","Duration":"01:16","Id":"1615","Brief":"当我们一直在为讲一个有道理有内涵的作品反复思考时，你会发现一些作者只是在对一些有趣的画面、细节进行着非常轻松地进行着描述。这部名为《Swim Meet》的作品就是如此，整部作品都在呈现节奏缓慢的游泳运动员以及一直在看时间的裁判，这在嘈杂快节奏的当今社会是一种难以寻找的状态，观看这部作品就会有难得一见的轻松感。另外，小分屏很别致\u2026\u2026","DetailPic":"http://ww2.sinaimg.cn/large/0066P23Wjw1evus0kli5aj30hs07sjsa.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTMwMjQxNjU2OA==.html","Name":"SWIM MEET(76)"},{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1euzlkyshmej3034034glz.jpg","Year":"2014","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?oip=2021932405&ep=eiaXE0qJUskA4irfiT8bb3m2fHQJXJZ3kmaA%2F5g1A8ZAMa%2FA6DPcqJq0Tfc%3D&vid=XMTI5Nzg3MTIwOA%3D%3D&type=hd3&ev=1&keyframe=1&ts=1439344707&token=7438&sid=8439344707901128ed836&ctype=12","sd":"http://pl.youku.com/playlist/m3u8?oip=2021932405&ep=eiaXE0qJUskA4irfiT8bb3m2fHQJXJZ3kmaA%2F5g1A8ZAMa%2FA6DPcqJq0Tfc%3D&vid=XMTI5Nzg3MTIwOA%3D%3D&type=hd3&ev=1&keyframe=1&ts=1439344707&token=7438&sid=8439344707901128ed836&ctype=12","hd":"http://pl.youku.com/playlist/m3u8?oip=2021932405&ep=eiaXE0qJUskA4irfiT8bb3m2fHQJXJZ3kmaA%2F5g1A8ZAMa%2FA6DPcqJq0Tfc%3D&vid=XMTI5Nzg3MTIwOA%3D%3D&type=hd3&ev=1&keyframe=1&ts=1439344707&token=7438&sid=8439344707901128ed836&ctype=12"},"Author":"Nicolas Ménard","Duration":"10:30","Id":"1612","Brief":"这是一段平凡的故事，描述了住在一栋楼的四个相互无关却又在生活中发生了交集的人，他们分别是伤心欲绝自寻短见未遂的家伙、网上赌博成瘾的姑娘、焦虑的孤独者和一个究竟盗窃怪癖者。除了这个奇妙的小故事外，作品的美术风格以及作者对于性格细节表达的视觉呈现和内容创意也令人印象深刻。 类别：剧情短片","DetailPic":"http://ww4.sinaimg.cn/large/0066P23Wjw1euzll3oju5j30hs07s0v8.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTI5Nzg3MTIwOA==.html","Name":"Loop Ring Chop Drink(630)"},{"HomePic":"http://ww3.sinaimg.cn/large/0066P23Wjw1euymwd5eoaj30340340sq.jpg","Year":"2015","VideoSite":"youku","VideoSource":{"uhd":"http://pl.youku.com/playlist/m3u8?oip=2021932405&ep=cyaXE0uLUMcF5CXaiT8bNC%2FkcHVeXJZ3kmaG%2F6YTSMZuLa%2FB6DPcqJ%2BwSPY%3D&vid=XMTI3NDAxMzUwNA%3D%3D&type=hd2&ev=1&keyframe=1&ts=1439266951&token=2069&sid=143926695165112c3642a&ctype=12","sd":"http://pl.youku.com/playlist/m3u8?oip=2021932405&ep=cyaXE0uLUMcF5CXaiT8bNC%2FkcHVeXJZ3kmaG%2F6YTSMZuLa%2FB6DPcqJ%2BwSPY%3D&vid=XMTI3NDAxMzUwNA%3D%3D&type=hd2&ev=1&keyframe=1&ts=1439266951&token=2069&sid=143926695165112c3642a&ctype=12","hd":"http://pl.youku.com/playlist/m3u8?oip=2021932405&ep=cyaXE0uLUMcF5CXaiT8bNC%2FkcHVeXJZ3kmaG%2F6YTSMZuLa%2FB6DPcqJ%2BwSPY%3D&vid=XMTI3NDAxMzUwNA%3D%3D&type=hd2&ev=1&keyframe=1&ts=1439266951&token=2069&sid=143926695165112c3642a&ctype=12"},"Author":"罗思佳","Duration":"04:00","Id":"1611","Brief":"罗思佳是川美今年的毕业生，之前热爱动画富有想象力的丝佳同学也常常参与冰糖葫芦与学术趴的集体动画项目，幽默怪异的风格给好多人留下了深刻印象，特别喜欢丝佳做动画的状态，愉快的创作，没有思想包袱，作品也十分有趣吸引人。她这次的毕业设计《大红和小蓝》同样传承了她一如既往的想象力~","DetailPic":"http://ww4.sinaimg.cn/large/0066P23Wjw1euymwhjin1j30hs07s76z.jpg","VideoUrl":"http://v.youku.com/v_show/id_XMTI3NDAxMzUwNA==.html","Name":"大红和小蓝(240)"}]
     */
    private List<AnimeEntity> anime;

    public void setAnime(List<AnimeEntity> anime) {
        this.anime = anime;
    }

    public List<AnimeEntity> getAnime() {
        return anime;
    }

    public class AnimeEntity {
        @Override
        public String toString() {
            return "AnimeEntity{" +
                    "HomePic='" + HomePic + '\'' +
                    ", Year='" + Year + '\'' +
                    ", VideoSite='" + VideoSite + '\'' +
                    ", VideoSource=" + VideoSource +
                    ", Author='" + Author + '\'' +
                    ", Duration='" + Duration + '\'' +
                    ", Id='" + Id + '\'' +
                    ", Brief='" + Brief + '\'' +
                    ", DetailPic='" + DetailPic + '\'' +
                    ", VideoUrl='" + VideoUrl + '\'' +
                    ", Name='" + Name + '\'' +
                    '}';
        }

        /**
         * HomePic : http://ww3.sinaimg.cn/large/0066P23Wjw1ew9qwfgqyyj30b50acdg5.jpg
         * Year : 2015
         * VideoSite : youku
         * VideoSource : {"uhd":"http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296","sd":"http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296","hd":"http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296"}
         * Author : 谭丽丽
         * Duration : 07:58
         * Id : 1624
         * Brief : 这部短片故事立意于现代人沉迷于社交网络，忽视身边的亲友。 我们可以在社交网络背后隐藏自己的表情，可以将每一句话发送之前反复修改，但是面对身边的家人和朋友，我们却很难袒露心声。故事讲述了一只企鹅，它乐于通过飘洋而来的漂流瓶中的故事去了解通过彼岸每一位的主人，她试图加入他们的世界，但是却没有任何人做出回应，悲观的主人公在放弃的同时却意外收到了一个特别的瓶子，它的主人看似来自遥远北极，而这位“不速之客”，给企鹅小姐带来一个巨大的惊喜。 背景音乐：《some》、《here is a heart》 感谢支持和帮助我的朋友们, 在今后的生活和工作上加油!不要忘了最初的梦想, 坚持！
         * DetailPic : http://ww1.sinaimg.cn/large/0066P23Wjw1ew9qwji01pj30hs0buwfy.jpg
         * VideoUrl : http://v.youku.com/v_show/id_XMTI2MTMxMDQ4OA==.html?from=s1.8-1-1.2
         * Name : 动画短片《等等等瓶》(478)
         */
        private String HomePic;
        private String Year;
        private String VideoSite;
        private VideoSourceEntity VideoSource;
        private String Author;
        private String Duration;
        private String Id;
        private String Brief;
        private String DetailPic;
        private String VideoUrl;
        private String Name;

        public void setHomePic(String HomePic) {
            this.HomePic = HomePic;
        }

        public void setYear(String Year) {
            this.Year = Year;
        }

        public void setVideoSite(String VideoSite) {
            this.VideoSite = VideoSite;
        }

        public void setVideoSource(VideoSourceEntity VideoSource) {
            this.VideoSource = VideoSource;
        }

        public void setAuthor(String Author) {
            this.Author = Author;
        }

        public void setDuration(String Duration) {
            this.Duration = Duration;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public void setBrief(String Brief) {
            this.Brief = Brief;
        }

        public void setDetailPic(String DetailPic) {
            this.DetailPic = DetailPic;
        }

        public void setVideoUrl(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getHomePic() {
            return HomePic;
        }

        public String getYear() {
            return Year;
        }

        public String getVideoSite() {
            return VideoSite;
        }

        public VideoSourceEntity getVideoSource() {
            return VideoSource;
        }

        public String getAuthor() {
            return Author;
        }

        public String getDuration() {
            return Duration;
        }

        public String getId() {
            return Id;
        }

        public String getBrief() {
            return Brief;
        }

        public String getDetailPic() {
            return DetailPic;
        }

        public String getVideoUrl() {
            return VideoUrl;
        }

        public String getName() {
            return Name;
        }

        public class VideoSourceEntity {
            /**
             * uhd : http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296
             * sd : http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296
             * hd : http://pl.youku.com/playlist/m3u8?vid=XMTI2MTMxMDQ4OA%3D%3D&keyframe=1&ev=1&ts=1442793459&type=hd2&ep=ciaQGE6EVcoF7CvajD8bZn%2Fldn4JXJZ3kmaH%2FLYfSMZQKezA6DPcqJi3SP0%3D&token=5762&oip=2021932405&ctype=12&sid=0442793459854121c7296
             */
            private String uhd;
            private String sd;
            private String hd;

            public void setUhd(String uhd) {
                this.uhd = uhd;
            }

            public void setSd(String sd) {
                this.sd = sd;
            }

            public void setHd(String hd) {
                this.hd = hd;
            }

            public String getUhd() {
                return uhd;
            }

            public String getSd() {
                return sd;
            }

            public String getHd() {
                return hd;
            }
        }
    }
}
