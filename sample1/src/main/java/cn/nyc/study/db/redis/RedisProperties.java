package cn.nyc.study.db.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis.cache")
public class RedisProperties {
	
	private int    expireSeconds;
    private String clusterNodes;
    private int    commandTimeout;
	/**
	 * @return expireSeconds
	 */
	public int getExpireSeconds() {
		return expireSeconds;
	}
	/**
	 * @param expireSeconds
	 */
	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	/**
	 * @return clusterNodes
	 */
	public String getClusterNodes() {
		return clusterNodes;
	}
	/**
	 * @param clusterNodes
	 */
	public void setClusterNodes(String clusterNodes) {
		this.clusterNodes = clusterNodes;
	}
	/**
	 * @return commandTimeout
	 */
	public int getCommandTimeout() {
		return commandTimeout;
	}
	/**
	 * @param commandTimeout
	 */
	public void setCommandTimeout(int commandTimeout) {
		this.commandTimeout = commandTimeout;
	}

}
