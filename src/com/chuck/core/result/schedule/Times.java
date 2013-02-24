package com.chuck.core.result.schedule;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

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

@Element
public class Times implements Serializable {

    @Element
    private Time arrival;

    @Element
    private Time departure;

    @Root
    public static class Time implements Serializable {

        @Element
        private String scheduled;

        @Element
        private String estimated;

        public String getScheduled() {
            return scheduled;
        }

        public String getEstimated() {
            return estimated;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "scheduled='" + scheduled + '\'' +
                    ", estimated='" + estimated + '\'' +
                    '}';
        }
    }

    public Time getArrival() {
        return arrival;
    }

    public Time getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "\nTimes{" +
                "arrival=" + arrival +
                ", \ndeparture=" + departure +
                '}';
    }
}
