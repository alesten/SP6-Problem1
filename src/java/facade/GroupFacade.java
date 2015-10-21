package facade; 

import callable.GroupInfoFinder;
import entity.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GroupFacade { 
    public List<Group> getGroups() throws Exception{
        List<String> urls = new ArrayList<String>() {
            {
                //Class A
                add("http://cphbusinessjb.cloudapp.net/CA2/");
                add("http://ca2-ebski.rhcloud.com/CA2New/");
                add("http://ca2-chrislind.rhcloud.com/CA2Final/");
                add("http://ca2-pernille.rhcloud.com/NYCA2/");
                add("https://ca2-jonasrafn.rhcloud.com:8443/company.jsp");
                add("http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/index.jsp");

                //Class B
                add("https://ca2-ssteinaa.rhcloud.com/CA2/");
                add("http://tomcat-nharbo.rhcloud.com/CA2/");
                add("https://ca2-cphol24.rhcloud.com/3.semCa.2/");
                add("https://ca2-ksw.rhcloud.com/DeGuleSider/");
                add("http://ca2-ab207.rhcloud.com/CA2/index.html");
                add("http://ca2-sindt.rhcloud.com/CA2/index.jsp");
                add("http://ca2gruppe8-tocvfan.rhcloud.com/");
                add("https://ca-ichti.rhcloud.com/CA2/");

                //Class COS
                add("https://ca2-9fitteen.rhcloud.com:8443/CA2/");
                add("https://cagroup04-coolnerds.rhcloud.com/CA_v1/index.html");
                add("http://catwo-2ndsemester.rhcloud.com/CA2/");
            }
        };
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        List<Future<Group>> list = new ArrayList<Future<Group>>();
        
        for (String url : urls) {
             Future<Group> future = executor.submit(new GroupInfoFinder(url));
             list.add(future);
        }
        
        List<Group> groups = new ArrayList();
        
        for (Future<Group> fGroup : list) {
            groups.add(fGroup.get());
        }
        
        executor.shutdown();
        return groups;
    }
}