package cn.chaZ.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-13 21:51
 **/

@Data
@ConfigurationProperties(prefix = "redis.sdk.config", ignoreInvalidFields = true)
public class RedisClientConfigProperties {
    /** host:ip */
    private String host;
    /** 端口 */
    private int prot;
    /** 密码 */
    private String password;
    /** 设置连接池大小，默认64 */
    private int poolSize = 64;
    /** 设置连接池的最小空闲连接数，默认10 */
    private int minIdleSize = 10;
    /** 设置连接的最大空闲时间（毫秒），超过改时间的空闲连接将被关闭，默认10000 */
    private int idleTimeout = 10000;
    /** 设置连接超时时间，默认10000 */
    private int connectTimeout = 10000;
    /** 设置连接重试次数，默认3次 */
    private int retryAttempts = 3;
    /** 设置连接重试的间隔时间，默认1000 */
    private int retryInterval = 1000;
    /** 设置定期检查连接是否可用的时间间隔（毫秒），默认0，表示不进行定期检查 */
    private int pingInterval = 0;
    /** 设置是否保持长连接，默认是 */
    private boolean keepAlive = true;
}
