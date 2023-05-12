import React,{useState, useEffect} from 'react'
import { Typography, Tag, Tooltip, Input, Button, message } from 'antd'
import { EditOutlined, DeleteOutlined, MoreOutlined } from '@ant-design/icons'
import axios from 'axios'

const { Title, Text } = Typography
const Cm = () => {
  const [catalogList, setCatalogList] = useState([])
  const getCatalogList = async () => {
    try {
      const res = await axios.get('/catalogs')
      console.log('cataloglist- ---', res)
      setCatalogList(res.data.data.list)
    } catch (error) {
      message(error)
    }
  }
  useEffect(() => {
    getCatalogList()
  }, [])
  return (
    <div>
      <div className='m8 p16 white-bg'>
        <div className='fs28 mb16'>Catalog</div>
        <Text>
          Catalogs provide metadata, such as databases, tables, partitions, views, and functions and information needed to access data stored in a database or other external systems.
        </Text>
      </div>
      <div className='m8 p24 main white-bg'>
        <div className='catalog-top-bar FBH FBJ mb16'>
          <div></div>
          <div>
            <Input.Search placeholder="keywords"  size="small" style={{width: '200px'}} />
            <Button type='primary' size="small" className='ml8'>Add</Button>
          </div>
        </div>
        {/* catalog-list */}
        <div className='catalog-list'>
          {
            catalogList.map(t => 
              <div className='list-item FBH FBJS gray-bd r4 p16 mb24'>
                <div className='item-logo pr24'>
                  logo
                </div>
                <div className='item-content'>
                  <div className='item-top FBH FBJ mb16'>
                    <div><span className='fs24 mr8'>{t.catalogName}</span> {t.defaultCatalog && <Tag>default</Tag>}</div>
                    <div className='options'>
                      <Tooltip title="edit">
                        <EditOutlined className='fc4 mr16 hand' />
                      </Tooltip>
                      <Tooltip title="delete">
                        <DeleteOutlined className='fc4 mr12 hand' />
                      </Tooltip>
                      <Tooltip title="more">
                        <MoreOutlined className='fc4 hand' />
                      </Tooltip>
                    </div>
                  </div>
                  <div className='item-info FBH FBJ'>
                    <Text>
                      <span className='i-label'>CatalogType：{t.catalogType}</span>
                    </Text>
                    <Text>
                      <span className='i-label'>DefaultDatabase：{t.defaultDatabase}</span>
                    </Text>
                    <Text>
                      <span className='i-label'>plugin：{t.pluginId}</span>
                    </Text>
                  </div>
                  <div className='item-info FBH FBJ'>
                    <Text>
                      <span className='i-label'>Describe：{t.descr}</span></Text>
                  </div>
                </div>
                
              </div>
            )
          }
          
        </div>
      </div>
    </div>
  )
}
export default Cm