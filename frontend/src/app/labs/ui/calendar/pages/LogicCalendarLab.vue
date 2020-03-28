<template>
    <div class="p-grid p-justify-center">
        <div class="p-col-5">
            <h1>Date & Times</h1>

            <tab-view>
                <tab-panel header="Date & Time">
                    <logic-calendar-date-time/>
                </tab-panel>
                <tab-panel header="Doc">
                    <logic-calendar-doc/>
                </tab-panel>
            </tab-view>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import LogicCalendarDoc from '@/app/labs/ui/calendar/components/LogicCalendarDoc.vue'
import LogicCalendarDateTime from '@/app/labs/ui/calendar/components/LogicCalendarDateTime.vue'

@Component({
  components: {
    LogicCalendarDateTime,
    LogicCalendarDoc
  }
})
export default class LogicCalendarLab extends Vue {
}
</script>

<style scoped>
</style>
