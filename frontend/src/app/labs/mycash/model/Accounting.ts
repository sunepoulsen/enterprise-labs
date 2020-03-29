import { Moment } from 'moment'

export enum AccountingStatus {
  ACTIVE,
  CLOSED
}

export interface Accounting {
  id: number;
  name: string;
  description?: string;
  startDate: Moment;
  endDate: Moment;
  status: AccountingStatus;
}
