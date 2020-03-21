/**
 * Representation of a lab
 */
import { Component } from 'vue-router/types/router'

export class LabRoute {
  path: string;
  component: Component;

  constructor (path: string, component: Component) {
    this.path = path
    this.component = component
  }
}
