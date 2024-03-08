/*******************************************************************************
 * Copyright (c) 2024 École Polytechnique de Montréal
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License 2.0 which
 * accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.tracecompass.incubator.rocm.core.ctfplugin.trace;

import org.eclipse.tracecompass.incubator.gpu.core.trace.IGpuTraceEventLayout.IApiEventLayout;
import org.eclipse.tracecompass.tmf.core.event.ITmfEvent;

/**
 * Event layout for API events in traces generated by the CTF plugin in ROCm
 *
 * @author Arnaud Fiorini
 */
public abstract class RocmApiCtfPluginEventLayout implements IApiEventLayout {

    @Override
    public boolean isBeginEvent(ITmfEvent event) {
        return event.getName().endsWith(RocmCtfPluginTraceEventLayout.HSA_BEGIN_SUFFIX) ||
                event.getName().endsWith(RocmCtfPluginTraceEventLayout.HIP_BEGIN_SUFFIX);
    }

    @Override
    public String getEventName(ITmfEvent event) {
        if (isBeginEvent(event)) {
            if (event.getName().startsWith(RocmCtfPluginTraceEventLayout.HIP)) {
                return event.getName().substring(0, event.getName().length() - 5);
            }
            return event.getName().substring(0, event.getName().length() - 6);
        }
        if (event.getName().startsWith(RocmCtfPluginTraceEventLayout.HIP)) {
            return event.getName().substring(0, event.getName().length() - 3);
        }
        return event.getName().substring(0, event.getName().length() - 4);
    }
}
