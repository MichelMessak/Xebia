/**
 * 
 */
package com.xebia.mowitnow.application.model;

/**
 * Enum that represent all exit's status possibles. 
 * 
 * @author Michel
 *
 */
public enum ExitStatus {

  /**
   * Successful termination
   */
  EX_OK(0),

  /**
   * The command was used incorrectly, e.g., with the wrong number of arguments,
   * a bad syntax in a parameter, or whatever.
   */
  EX_USAGE(1),

  /**
   * The job execution failed for some reason
   */
  EX_RUNEX(2),

  /**
   * The input/output resources are not available
   */
  EX_IO(3);

  /**
   * @param value
   */
  private ExitStatus(Integer value) {
    this.value = value;
  }

  /**
   * @return enum's value
   */
  public Integer getValue() {
    return value;
  }

  private Integer value;
}
