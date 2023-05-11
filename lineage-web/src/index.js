import React from 'react'
import ReactDOM from 'react-dom'
import { HashRouter, Routes, Route } from 'react-router-dom'
import './index.css'
import App from './App'
import PageJob from './page-sql'
import JobSql from './page-sql/job-sql'
import JobList from './page-sql/job-list'
import PageJobList from './page-sql/job-list'
import PageCatalog from './page-catalog'
import PageCatalogList from './page-catalog/catalog-list'
import PageCatalogDetail from './page-catalog/catalog-detail'

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
        <Route path="catalog" element={<PageCatalog />}>
          <Route index element={<PageCatalogList />} />
          <Route path="list" element={<PageCatalogList />} />
          <Route path="detail?/:id" element={<PageCatalogDetail />} />
        </Route>
        <Route
          path="*"
          element={
            <main style={{ padding: '1rem' }}>
              <p className="fc45">正在开发建设中，敬请期待～</p>
            </main>
          }
        />
      </Route>
      
    </Routes>
  </HashRouter>
}
export default ReactSample

ReactDOM.render(<ReactSample />, document.getElementById('root'))
