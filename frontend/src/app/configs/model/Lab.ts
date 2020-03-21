/**
 * Representation of a lab
 */
import { LabRoute } from '@/app/configs/model/LabRoute'

export class Lab {
  name: string;
  route: LabRoute;

  constructor (name: string, route: LabRoute) {
    this.name = name
    this.route = route
  }
}
