package com.example.jnosql.redis;

import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.redis.key.Counter;
import org.jnosql.diana.redis.key.RedisBucketManagerFactory;
import org.jnosql.diana.redis.key.RedisConfiguration;
import org.jnosql.diana.redis.key.SortedSet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.List;
import java.util.Queue;
import java.util.Set;

@ApplicationScoped
public class RedisProducer {

    private static final String BUCKET = "users";

    private RedisConfiguration configuration;

    private RedisBucketManagerFactory managerFactory;

    @PostConstruct
    public void init () {
        configuration = new RedisConfiguration();
        managerFactory = configuration.get();
    }

    @Produces
    public BucketManager getManager () {
        return managerFactory.getBucketManager(BUCKET);
    }

    @Produces
    public List<String> getList(){
        return managerFactory.getList("productList", String.class);
    }

    @Produces
    public Set<String> getSet(){
        return managerFactory.getSet("productSet", String.class);
    }

    @Produces
    public Queue<String> getQueue(){
        return managerFactory.getQueue("queue", String.class);
    }

    @Produces
    public Counter getCounter() {
        return managerFactory.getCounter("counter");
    }

    @Produces
    public SortedSet getSortedSet() {
        return managerFactory.getSortedSet("soccer");
    }


}
