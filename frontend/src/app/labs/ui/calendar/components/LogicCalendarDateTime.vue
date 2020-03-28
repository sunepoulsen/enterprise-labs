<template>
    <div>
        <Card>
            <template slot="title">Timestamp</template>

            <template slot="content">
                Enter a timestamp in the format <span class="text-code">DD-MM-YYYY HH:mm:ss.SSS ZZ</span> or an epoch.
                <p/>
                <label-grid label="Timestamp or epoch" :width="labelWidth">
                    <InputText class="date-time-field tel-right-space" type="text" v-model="dateTimeField"/>
                    <Button class="p-button-raised tel-right-space" label="Calculate" @click="calculateTimestapValues" />
                    <Button class="p-button-raised" label="Now" @click="updateDateWithCurrent" />
                </label-grid>
                <p/>
                <label-grid label="Epoch" :width="labelWidth">{{ epochField }}</label-grid>
                <label-grid label="Date" :width="labelWidth">{{ dateField }}</label-grid>
                <label-grid label="Time" :width="labelWidth">{{ timeField }}</label-grid>
                <label-grid label="Days since epoch" :width="labelWidth">{{ daysAfterEpochField }}</label-grid>
                <label-grid label="Week" :width="labelWidth">{{ weekField }}</label-grid>
                <label-grid label="Month" :width="labelWidth">{{ monthField }}</label-grid>
                <label-grid label="Year" :width="labelWidth">{{ yearField }}</label-grid>
                <label-grid label="Is leap year" :width="labelWidth">{{ leapYearField }}</label-grid>
            </template>
        </Card>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import moment, { Moment } from 'moment'
import LabelGrid from '@/app/shared/components/layouts/LabelGrid.vue'

@Component({
  components: {
    LabelGrid
  }
})
export default class LogicCalendarDateTime extends Vue {
  // Constants
  static dateTimeFormat = 'DD-MM-YYYY HH:mm:ss.SSS ZZ';
  labelWidth = '160px';

  // Data model
  private dateTime: Moment = moment.invalid();

  // Component models
  private dateTimeField = '';
  private epochField = '';
  private dateField = '';
  private timeField = '';
  private daysAfterEpochField = '';
  private weekField = '';
  private monthField = '';
  private yearField = '';
  private leapYearField = '';

  updateDateWithCurrent () {
    this.dateTimeField = moment().format(LogicCalendarDateTime.dateTimeFormat)
  }

  calculateTimestapValues () {
    let m = moment(this.dateTimeField, LogicCalendarDateTime.dateTimeFormat)
    if (!m.isValid()) {
      m = moment.unix(Number(this.dateTimeField))
    }

    if (!m.isValid()) {
      return
    }

    this.dateTime = m
    this.epochField = this.dateTime.format('x')
    this.dateField = this.dateTime.format('DD-MM-YYYY')
    this.timeField = this.dateTime.format('HH:mm:ss.SSS')
    this.daysAfterEpochField = this.dateTime.diff(moment.unix(0), 'days').toString()
    this.weekField = this.dateTime.week().toString()
    this.monthField = (this.dateTime.month() + 1).toString()
    this.yearField = this.dateTime.year().toString()
    this.leapYearField = '' + this.dateTime.isLeapYear()
  }
}
</script>

<style scoped lang="scss">
    @import '@/assets/styles/global.scss';

    .date-time-field {
        width: 180pt;
    }
</style>
