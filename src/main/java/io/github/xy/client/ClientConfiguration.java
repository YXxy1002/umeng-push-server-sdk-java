package io.github.xy.client;

import java.util.Objects;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class ClientConfiguration {
    public static final int DEFAULT_MAX_RETRIES = 3;
    /**
     * 默认超时时间（毫秒）
     */
    public static final long DEFAULT_CONNECT_TIMEOUT = 10000L;
    public static final long DEFAULT_READ_TIMEOUT = 10000L;
    public static final long DEFAULT_WRITE_TIMEOUT = 10000L;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private long connectTimeout = DEFAULT_CONNECT_TIMEOUT;
    private long readTimeout = DEFAULT_READ_TIMEOUT;
    private long writeTimeout = DEFAULT_WRITE_TIMEOUT;

    public ClientConfiguration() {
    }

    public ClientConfiguration(int maxRetries, long connectTimeout, long readTimeout, long writeTimeout) {
        this.maxRetries = maxRetries;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
    }

    private ClientConfiguration(Builder builder) {
        this.maxRetries = builder.maxRetries;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public static final class Builder {
        private int maxRetries = DEFAULT_MAX_RETRIES;
        private long connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        private long readTimeout = DEFAULT_READ_TIMEOUT;
        private long writeTimeout = DEFAULT_WRITE_TIMEOUT;

        private Builder() {
        }

        public ClientConfiguration build() {
            return new ClientConfiguration(this);
        }

        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        public Builder connectTimeout(long connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(long readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder writeTimeout(long writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientConfiguration that = (ClientConfiguration) o;
        return maxRetries == that.maxRetries &&
                connectTimeout == that.connectTimeout &&
                readTimeout == that.readTimeout &&
                writeTimeout == that.writeTimeout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxRetries, connectTimeout, readTimeout, writeTimeout);
    }
}
