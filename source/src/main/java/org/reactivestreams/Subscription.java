/***************************************************
 * Licensed under MIT No Attribution (SPDX: MIT-0) *
 ***************************************************/

package org.reactivestreams;

/**
 * A {@link Subscription} represents a one-to-one lifecycle of a {@link Subscriber} subscribing to a {@link Publisher}.
 * <p>
 * It can only be used once by a single {@link Subscriber}.
 * <p>
 * It is used to both signal desire for data and cancel demand (and allow resource cleanup).
 */
// TODO: 2021/1/10 代表一个订阅者订阅发布者的整个生命周期
public interface Subscription {

    /**
     * No events will be sent by a {@link Publisher} until demand is signaled via this method.
     * <p>
     *  It can be called however often and whenever needed—but if the outstanding cumulative demand ever becomes Long.MAX_VALUE or more,
     *  it may be treated by the {@link Publisher} as "effectively unbounded".
     * <p>
     * Whatever has been requested can be sent by the {@link Publisher} so only signal demand for what can be safely handled.
     * <p>
     * A {@link Publisher} can send less than is requested if the stream ends but
     * then must emit either {@link Subscriber#onError(Throwable)} or {@link Subscriber#onComplete()}.
     * 
     * @param n the strictly positive number of elements to requests to the upstream {@link Publisher}
     */
    // TODO: 2021/1/10 请求publisher发布事件 
    public void request(long n);

    /**
     * Request the {@link Publisher} to stop sending data and clean up resources.
     * <p>
     * Data may still be sent to meet previously signalled demand after calling cancel.
     */
    // TODO: 2021/1/10 请求publisher停止发布事件，并清除资源
    public void cancel();
}
