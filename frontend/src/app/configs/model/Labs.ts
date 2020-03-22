import { Component } from 'vue-router/types/router'

/**
 * Representation of a lab group
 */
export interface LabGroup {
  name: string;
  labs: Lab[];
}

/**
 * Representation of a lab
 */
export interface Lab {
  name: string;
  route: LabRoute;
}

/**
 * Representation of a route to a lab
 */
export interface LabRoute {
  path: string;
  component: Component;
}
