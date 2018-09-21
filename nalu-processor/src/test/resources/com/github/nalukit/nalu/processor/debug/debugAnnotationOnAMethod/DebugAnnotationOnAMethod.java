package com.github.nalukit.nalu.processor.debug.debugAnnotationOnAMethod;

import com.github.nalukit.nalu.client.application.IsApplication;
import com.github.nalukit.nalu.client.application.annotation.Application;
import com.github.nalukit.nalu.client.application.annotation.Debug;
import com.github.nalukit.nalu.processor.common.MockContext;
import com.github.nalukit.nalu.processor.common.MockLogger;
import com.github.nalukit.nalu.processor.common.MockShell;

@Application(shell = MockShell.class, startRoute = "/search", context = MockContext.class)
public interface DebugAnnotationOnAMethod
  extends IsApplication {

  @Debug(logger = MockLogger.class)
  void oneEvent();

}