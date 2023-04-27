import React from 'react'
import ReactDOM from 'react-dom'
import { HashRouter, Routes, Route } from 'react-router-dom'
import './index.css'
import App from './App'
import PageJob from './page-sql'
import JobSql from './page-sql/job-sql'
import JobList from './page-sql/job-list'
import PageJobList from './page-sql/job-list'
import PageTaskManage from './page-task-manage'

const ReactSample = () => {
  return <HashRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route index element={<PageJob />} />
        <Route path="job" element={<PageJob />}>
          <Route index element={<JobList />} />
          <Route path="list" element={<JobList />} />
          <Route path="sql?/:id" element={<JobSql />} />
        </Route>
        <Route path="task-manage" element={<PageTaskManage />} />
      </Route>
    </Routes>
  </HashRouter>
}
export default ReactSample

ReactDOM.render(<ReactSample />, document.getElementById('root'))
