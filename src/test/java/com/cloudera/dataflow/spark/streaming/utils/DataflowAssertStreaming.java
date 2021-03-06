/*
 * Copyright (c) 2015, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */
package com.cloudera.dataflow.spark.streaming.utils;

import com.cloudera.dataflow.spark.EvaluationResult;

import org.junit.Assert;

/**
 * Since DataflowAssert doesn't propagate assert exceptions, use Aggregators to assert streaming
 * success/failure counters.
 */
public final class DataflowAssertStreaming {
  /**
   * Copied aggregator names from {@link com.google.cloud.dataflow.sdk.testing.DataflowAssert}
   */
  static final String SUCCESS_COUNTER = "DataflowAssertSuccess";
  static final String FAILURE_COUNTER = "DataflowAssertFailure";

  private DataflowAssertStreaming() {
  }

  public static void assertNoFailures(EvaluationResult res) {
    int failures = res.getAggregatorValue(FAILURE_COUNTER, Integer.class);
    Assert.assertEquals("Found " + failures + " failures, see the log for details", 0, failures);
  }
}
