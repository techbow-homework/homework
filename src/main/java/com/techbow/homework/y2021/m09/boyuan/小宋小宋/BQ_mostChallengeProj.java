package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class BQ_mostChallengeProj {
//    S: In our battery system, the data dashboard gets real time data from data-ingest microservice. During the pressure test, we found that the data may lost, and so that we try to figure out the root cause,
//    T: But finding the root cause is always a challenge. We analyzed the test result and found that for general QPS，the data is stable. but in the benchmark test, with higher QPS, some data would be lost. So I did some research, and found out the lost data may be due to the data spike. Our server can not handle data spikes and write data into MySQL.
//    A: At that time, it was a big challenge for me, because I am not familiar with the situation and the techlead is out of office. At the same time, we have a tight ddl. The first idea coming up is to add more servers, but we don’t have enough budget. Also, if the QPS keeps rising, we still can’t handle it. To make some progress, I searched a lot of related situations on our company’s website. I found that there was one gay faced similiar situation and what he did is to use MessageQueue （RabbitMQ） and add a service to periodically get data from the MessageQueue and then write the data into our database to resolve the data spike.
//    R: After I did it, I really solved this problem.

}
