/*******************************************************************************
 * Copyright 2020 Pinterest, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.pinterest.orion.core.actions.generic;

import com.pinterest.orion.utils.OrionConstants;

public class NodeMaintenanceActions {
  public static class EnableNodeMaintenanceAction extends NodeAction {

    @Override
    public void runAction() throws Exception {
      if(!initializeNode(false)) {
        return;
      }
      node.setMaintenance(true);
      markSucceeded();
    }

    @Override
    public String getName() {
      return "EnableMaintenanceMode" + (node == null ? "" : " - Node " + getAttribute(OrionConstants.NODE_ID).getValue().toString());
    }

    @Override
    protected void postActionValidation() throws Exception {
      return;
    }
  }

  public static class DisableNodeMaintenanceAction extends NodeAction {

    @Override
    public void runAction() throws Exception {
      if(!initializeNode(false)) {
        return;
      }
      node.setMaintenance(false);
      markSucceeded();
    }

    @Override
    public String getName() {
      return "DisableMaintenanceMode" + (node == null ? "" : " - Node " + getAttribute(OrionConstants.NODE_ID).getValue().toString());
    }

    @Override
    protected void postActionValidation() throws Exception {
      return;
    }
  }
}
