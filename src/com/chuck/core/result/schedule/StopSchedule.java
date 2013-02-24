package com.chuck.core.result.schedule;

import com.chuck.core.result.Result;
import com.chuck.core.result.stops.StopNode;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

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
@Root(name = "stop-schedule")
public class StopSchedule extends Result {

    @Element
    private StopNode stop;

    @ElementList(name = "route-schedules")
    private List<RouteSchedule> routeSchedules;

    public StopNode getStop() {
        return stop;
    }

    public List<RouteSchedule> getRouteSchedules() {
        return routeSchedules;
    }

    @Override
    public String toString() {
        return "\nStopSchedule{" +
                "stop=" + stop +
                ", routeSchedules=" + routeSchedules +
                '}';
    }
}
