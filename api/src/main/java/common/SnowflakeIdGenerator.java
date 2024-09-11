package common;

public class SnowflakeIdGenerator {
    // 设定时间起点（Unix时间戳，单位为毫秒）
    private final long epoch = 1672537600000L; // 2023-01-01 00:00:00

    // 机器标识占用的位数
    private final long workerIdBits = 5L;
    // 数据中心标识占用的位数
    private final long datacenterIdBits = 5L;
    // 支持的最大机器编号
    private final long maxWorkerId = ~(-1L << workerIdBits);
    // 支持的最大数据中心编号
    private final long maxDatacenterId = ~(-1L << datacenterIdBits);
    // 序列号占用的位数
    private final long sequenceBits = 12L;

    // 机器 ID 左移位数
    private final long workerIdShift = sequenceBits;
    // 数据中心 ID 左移位数
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间戳左移位数
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    // 序列号
    private long sequence = 0L;
    // 上次生成 ID 的时间戳
    private long lastTimestamp = -1L;

    private final long workerId; // 当前机器 ID
    private final long datacenterId; // 当前数据中心 ID

    public SnowflakeIdGenerator(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        // 如果当前时间小于上一次生成 ID 的时间戳，说明系统时钟回退
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock is moving backwards. Rejecting requests until " + lastTimestamp);
        }

        // 如果是同一时间生成的，则序列号加 1
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & ~(-1L << sequenceBits); // 序列号取模
        } else {
            sequence = 0L; // 时间不同，序列号重置
        }

        lastTimestamp = timestamp;

        // 移位并返回 ID
        return ((timestamp - epoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }
}
