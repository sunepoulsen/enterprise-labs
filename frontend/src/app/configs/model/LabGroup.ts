/**
 * Representation of a lab group
 */
import { Lab } from '@/app/configs/model/Lab'

export class LabGroup {
  name: string;
  labs: Lab[];

  constructor (name: string, labs: Lab[]) {
    this.name = name
    this.labs = labs
  }
}
