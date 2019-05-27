package springBootStarter.topicController;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "SCore Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaSrcipt Description")));

    public List<Topic> getAllTopics(){
        return this.topics;
    }

    public Topic getTopic(String id)
    {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }



    public void addTopic(Topic topic) {
        topics.add(topic);
    }


    public void updateTopic(String id, Topic topic) {
        for(int i=0; i<topics.size(); i++)
        {
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
        System.out.println("deleted");
    }
}
