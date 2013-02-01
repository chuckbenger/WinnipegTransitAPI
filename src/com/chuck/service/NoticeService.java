package com.chuck.service;

import com.chuck.core.filter.FilterQuery;
import com.chuck.core.result.message.SystemMessage;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
public class NoticeService extends TransitService {

    private static NoticeService INSTANCE;

    /**
     * Returns an instance of NoticeService
     *
     * @return returns a NoticeService object
     */
    public static NoticeService getInstance() {

        if (INSTANCE == null)
            INSTANCE = new NoticeService();

        return INSTANCE;
    }

    /**
     * Sends a web request to get any system messages which are usually urgent notices
     *
     * @return returns a System Message object which contains any messages
     * @throws Exception
     */
    public SystemMessage getSystemMessages() throws Exception {
        FilterQuery filterQuery = new FilterQuery(this);
        return executeQuery(filterQuery, SystemMessage.class);
    }

    @Override
    public String getServiceName() {
        return "system-messages";
    }
}



























