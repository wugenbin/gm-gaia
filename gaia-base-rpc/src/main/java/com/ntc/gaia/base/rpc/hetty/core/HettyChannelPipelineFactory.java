package com.ntc.gaia.base.rpc.hetty.core;

import static org.jboss.netty.channel.Channels.*;

import java.util.concurrent.ExecutorService;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpContentCompressor;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;


/**
 * HettyChannelPipelineFactory
 * 
 * @author david
 * @date 2017-07-20
 *
 */
public class HettyChannelPipelineFactory implements ChannelPipelineFactory {

	private ExecutorService threadpool;

	public HettyChannelPipelineFactory(ExecutorService threadpool) {
		this.threadpool = threadpool;
	}

	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = pipeline();
		pipeline.addLast("decoder", new HttpRequestDecoder());
		pipeline.addLast("aggregator", new HttpChunkAggregator(1048576));
		pipeline.addLast("encoder", new HttpResponseEncoder());
		pipeline.addLast("deflater", new HttpContentCompressor());
		pipeline.addLast("handler", new HettyHandler(threadpool));
		return pipeline;
	}

}
