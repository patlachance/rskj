package co.rsk.net.sync;

import com.google.common.annotations.VisibleForTesting;

import javax.annotation.concurrent.Immutable;
import java.time.Duration;

@Immutable
public final class SyncConfiguration {
    public static final SyncConfiguration DEFAULT = new SyncConfiguration(5, 60, 10, 10, 20);

    @VisibleForTesting
    public static final SyncConfiguration IMMEDIATE_FOR_TESTING = new SyncConfiguration(1, 1, 3, 1, 5);

    private final int expectedPeers;
    private final Duration timeoutWaitingPeers;
    private final Duration timeoutWaitingRequest;
    private final Duration expirationTimePeerStatus;
    private final int maxSkeletonChunks;

    /**
     * @param expectedPeers The expected number of peers we would want to start finding a connection point.
     * @param timeoutWaitingPeers Timeout in minutes to start finding the connection point when we have at least one peer
     * @param timeoutWaitingRequest Timeout in seconds to wait for syncing requests
     * @param expirationTimePeerStatus Expiration time in minutes for peer status
     * @param maxSkeletonChunks Maximum amount of chunks included in a skeleton message
     */
    public SyncConfiguration(int expectedPeers, int timeoutWaitingPeers, int timeoutWaitingRequest, int expirationTimePeerStatus, int maxSkeletonChunks) {
        this.expectedPeers = expectedPeers;
        this.timeoutWaitingPeers = Duration.ofSeconds(timeoutWaitingPeers);
        this.timeoutWaitingRequest = Duration.ofSeconds(timeoutWaitingRequest);
        this.expirationTimePeerStatus = Duration.ofMinutes(expirationTimePeerStatus);
        this.maxSkeletonChunks = maxSkeletonChunks;
    }

    public final int getExpectedPeers() {
        return expectedPeers;
    }

    public final int getMaxSkeletonChunks() {
        return maxSkeletonChunks;
    }

    public final Duration getTimeoutWaitingPeers() {
        return timeoutWaitingPeers;
    }

    public final Duration getTimeoutWaitingRequest() {
        return  timeoutWaitingRequest;
    }

    public final Duration getExpirationTimePeerStatus() {
        return expirationTimePeerStatus;
    }
}