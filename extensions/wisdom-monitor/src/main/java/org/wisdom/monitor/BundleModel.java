/*
 * #%L
 * Wisdom-Framework
 * %%
 * Copyright (C) 2013 - 2014 Wisdom Framework
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.wisdom.monitor;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import java.util.*;

/**
 * Bundle Model.
 */
public class BundleModel {

    public BundleModel(Bundle bundle) {
        this.bundle = bundle;
    }

    public static List<BundleModel> bundles(BundleContext context) {
        List<BundleModel> bundles = new ArrayList<BundleModel>();
        for (Bundle bundle : context.getBundles()) {
            bundles.add(new BundleModel(bundle));
        }
        return bundles;
    }

    private final Bundle bundle;

    public String getState() {
        switch(bundle.getState()) {
            case Bundle.ACTIVE: return "ACTIVE";
            case Bundle.INSTALLED: return "INSTALLED";
            case Bundle.RESOLVED: return "RESOLVED";
            case Bundle.STARTING: return "STARTING";
            case Bundle.STOPPING: return "STOPPING";
            case Bundle.UNINSTALLED: return "UNINSTALLED";
            default: return Integer.toString(bundle.getState());
        }
    }

    public long getId() {
        return bundle.getBundleId();
    }

    public String getName() {
        return bundle.getSymbolicName() + " - " + bundle.getVersion();
    }

    public Map<String, String> getHeaders() {
        Map<String, String> map = new TreeMap<String, String>();
        Enumeration<String> enumeration = bundle.getHeaders().keys();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            map.put(key, bundle.getHeaders().get(key));
        }
        return map;
    }
}
