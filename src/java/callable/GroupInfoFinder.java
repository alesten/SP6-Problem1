package callable; 

import entity.Group;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GroupInfoFinder implements Callable<Group>{ 

    private String url;

    public GroupInfoFinder(String url) {
        this.url = url;
    }
    
    @Override
    public Group call() throws Exception {
        Group group = new Group();
        
        Document doc = Jsoup.connect(url).get();
        Elements ele = doc.select("#authors");
        group.setGroupAuthors(ele.text());
        ele = doc.select("#class");
        group.setGroupClass(ele.text());
        ele = doc.select("#group");
        group.setGroupNumber(ele.text());
        
        return group;
    }
}