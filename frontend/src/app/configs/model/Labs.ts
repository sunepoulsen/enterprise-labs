import { RouteConfig } from 'vue-router'

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
  route: RouteConfig;
}
